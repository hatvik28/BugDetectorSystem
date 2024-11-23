import os
import subprocess
import xml.etree.ElementTree as ET
import json
# from fetchcode import fetch_java_files_from_github

# Load SpotBugs descriptions from JSON
with open("bug_descriptions.json", "r") as f:
    bug_descriptions = json.load(f)


def compile_java_files(src_dir, bin_dir):
    """Compile Java files from src_dir to bin_dir."""
    os.makedirs(bin_dir, exist_ok=True)
    compile_command = ["javac", "-d", bin_dir] + \
        [os.path.join(src_dir, f)
         for f in os.listdir(src_dir) if f.endswith(".java")]
    subprocess.run(compile_command, check=True)


def run_spotbugs_analysis(class_dir, report_path):
    """Run SpotBugs analysis on compiled class files and output XML report."""
    # Remove the old report file if it exists
    if os.path.exists(report_path):
        os.remove(report_path)
        print(f"Deleted old SpotBugs report: {report_path}")

    # SpotBugs command
    spotbugs_command = [
        # Adjust path to SpotBugs batch file
        "C:\\Users\\hatvi\\spotbugs-4.8.6\\bin\\spotbugs.bat",
        "-textui",
        "-effort:max",
        "-low",
        "-xml",
        "-output", report_path,
        class_dir
    ]

    # Run SpotBugs command
    subprocess.run(spotbugs_command, check=True)


def parse_spotbugs_xml(report_path):
    """Parse SpotBugs XML report and return issues with descriptions."""
    issues = []
    try:
        tree = ET.parse(report_path)
        root = tree.getroot()

        for bug_instance in root.findall('BugInstance'):
            category = bug_instance.get('category')
            severity = bug_instance.get('priority')
            type_ = bug_instance.get('type')

            # Get description from JSON or a default message
            description = bug_descriptions.get(
                type_, "No description available.")

            for source_line in bug_instance.findall('SourceLine'):
                file_path = source_line.get('sourcepath')
                line_number = source_line.get('start')

                # Collect issue details
                issues.append({
                    "file": file_path,
                    "line": line_number,
                    "category": category,
                    "severity": severity,
                    "type": type_,
                    "description": description
                })
    except ET.ParseError as e:
        print(f"Error parsing XML report: {e}")
    return issues


def remove_duplicate_bugs(issues):
    """
    Remove duplicate bug entries based on unique attributes.
    Duplicates are identified by the combination of file, line, and type.
    """
    unique_bugs = []
    seen = set()

    for issue in issues:
        # Create a unique identifier for each bug
        bug_id = (issue["file"], issue["line"], issue["type"])
        if bug_id not in seen:
            seen.add(bug_id)
            unique_bugs.append(issue)

    return unique_bugs


def display_spotbugs_issues(issues):
    """Display SpotBugs issues in the terminal with descriptions."""
    print("\nSpotBugs Analysis Report:")
    for issue in issues:
        print(f"\nFile: {issue['file']}")
        print(f"Line Number: {issue['line']}")
        print(f"Category: {issue['category']}")
        print(f"Severity: {issue['severity']}")
        print(f"Type: {issue['type']}")
        print(f"Description: {issue['description']}")
        print("-" * 50)


if __name__ == "__main__":
    output_dir = "src"  # Directory where fetched Java files will be saved
    bin_dir = "bin"  # Directory for compiled .class files
    spotbugs_report_path = "spotbugs_report.xml"  # XML output for SpotBugs report

    # Step 2: Compile Java files for SpotBugs analysis
    compile_java_files(output_dir, bin_dir)

    # Step 3: Run SpotBugs analysis
    run_spotbugs_analysis(bin_dir, spotbugs_report_path)

    # Step 4: Parse and display the SpotBugs report
    spotbugs_issues = parse_spotbugs_xml(spotbugs_report_path)

    unique_bugs = remove_duplicate_bugs(spotbugs_issues)

    display_spotbugs_issues(spotbugs_issues)
