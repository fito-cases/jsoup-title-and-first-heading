# Intended approach (evaluator only)

In `PageSummarizer.summarize(String)`, parse the supplied HTML string with jsoup into a Document. The starter already obtains the title via `page.title()`; select the first `h1` within `page.body()` (for example, `page.body().selectFirst("h1")`) and obtain its full text with `text()`, including nested text. The supplied fixture pages both have body h1 elements. Avoid string-search shortcuts and network access. On `main`, `./gradlew test --offline` runs two tests: `returnsTitleForSuppliedPages()` passes and `summarizesSuppliedPages()` fails because the heading is empty. The local `case/solution-v1.0.0` branch holds the working implementation; its test suite should pass.

# Rubric expectations

- **page-title (APPLICATION, 50):** Verify the returned title against supplied HTML, including whitespace and character-reference edge cases for score 3. Score 2 requires correct page titles across supplied pages; partial credit is for some correct titles only.
- **first-body-heading (APPLICATION, 50):** Verify the first body h1 is selected, not later headings or text outside the body, and nested text is retained. Score 2 requires correct first-heading results across supplied pages; score 3 requires resilience to distracting later/outside headings.
