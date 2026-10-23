# Source specification — Read a Page’s Title and First Body Heading

## Project

Greenfield Java 21/Gradle 9 project using jsoup 1.x and JUnit 5. The ticket describes a page-summary feature receiving a **complete HTML page as a string**; supply an ordinary Java source tree (`src/main/java`, `src/test/java`) with a small `PageSummary` value holding `title` and `firstBodyHeading`, and a `PageSummarizer` entry point accepting the HTML string and returning that value. Keep sample pages as local strings or local test fixtures; no URL fetch or network dependency during extraction. Name the tests `PageSummaryTest` and keep their fixture HTML legible so the ticket's nested content, multiple headings and head/body separation are visible in the tree.

The intended solution parses with `org.jsoup.Jsoup.parse(String)` into `org.jsoup.nodes.Document`; obtain `Document.title()` and select the first `h1` **within** `Document.body()` with jsoup's `Element.selectFirst("h1")`, then read the selected `Element.text()`. These API shapes are grounded in the jsoup 1.x HTML Document and Document Object Model examples (the latter demonstrates `selectFirst` and element traversal; the former demonstrates `body()` and `title()`). Verify the precise null/absence policy for a page with no body `h1` against the actual installed jsoup release before implementing it; the supplied fixture pages all have body headings. Do not compare raw markup or assume node indices only count elements.

Build files must include the Java application/library source set, a working JUnit 5 test task with its platform launcher for Gradle 9, jsoup 1.x as a runtime dependency, a Gradle 9 wrapper, and a `.gitignore` excluding `.gradle/`, `build/`, and other generated output. Resolve real compatible releases before recording versions; do not fabricate patch versions. The source work's observable check is `./gradlew test` (or `gradlew.bat test` on Windows). **The rubric contains no automated or hybrid gate command or passing condition**: both criteria, `page-title` and `first-body-heading`, use AI evaluation, so the test task is project evidence and a plan verification, not a substituted rubric gate.

## Starter state — original branch carrying `.case/`

The implementation starter is a compilable, incomplete `PageSummarizer`: it parses the supplied string and obtains the correct title, but leaves the returned first body heading blank. No completed heading extraction, solution code, or hints/spoilers in the starter. Keep a passing title-only check and at least one independent passing project check. In `PageSummaryTest.summarizesSuppliedPages`, the very first supplied page has a nonempty first body `h1`, and its assertion of `firstBodyHeading` fails (actual empty string, expected the first body heading's complete text); this is the **only** failing test. A full `./gradlew test` must compile and run the suite but exit nonzero for exactly that one test; other tests pass. No `failing_tests` names or build status are specified by `known_state.yaml`, so this named test and the compilation expectation make its single known error executable without treating invented test names as contract-specified.

Known error, verbatim from the starter contract:

> type: incorrect_page_summary
> description: "At least one supplied HTML page does not yield the expected page title and first body h1 text in the starter implementation."

The starter description further requires that the component does not yet produce both correct page title and first body heading text across the supplied pages. The single named failure above proves that exact condition; avoid collateral build failures or failing tests.

## Solution state — local branch `case/solution-v1.0.0`

`PageSummarizer` returns both pieces of text correctly for every supplied complete HTML string. Include fixtures with multiple body headings, nested inline content in the first body heading, character references and surrounding whitespace in title content, and distracting `h1`-like text in the head (for example an attribute of a `meta` element). Tests demonstrate decoded/normalized title text, nested text retained, and selection of the first body `h1` rather than later headings or markup outside the body. `./gradlew test` exits zero with all tests passing. Deliverable, verbatim: "A working page-summary component that returns the page title and first body h1 text from the supplied HTML string."

Rubric gates: **none** (both rubric criteria use `evaluation_method.type: ai`; there are no `automated`/`hybrid` commands or passing conditions to copy). Demonstrate the two AI-evaluated criteria `page-title` and `first-body-heading` with the implementation and passing fixture tests; do not claim that the project test command is a rubric gate.

## Constraints

Use only the supplied HTML string; do not fetch a page from the network. The returned heading must be the first `<h1>` within the document body, including nested text when present. Preserve the ticket's page-level metadata/body distinction and work on parsed structure rather than substring matching or fragment-only extraction. Keep `case/solution-v1.0.0` locally reachable; publishing is separate.
