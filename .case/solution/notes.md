# Intended approach (evaluator only)

Parse the supplied HTML string with jsoup into a Document. Obtain the page title from the document and select the first h1 within the parsed body; obtain that heading's full text, including nested text. Avoid string-search shortcuts and network access. Refine the exact entry point and test evidence after the starter project exists.

# Rubric expectations

- **page-title (APPLICATION, 50):** Verify the returned title against supplied HTML, including whitespace and character-reference edge cases for score 3. Score 2 requires correct page titles across supplied pages; partial credit is for some correct titles only.
- **first-body-heading (APPLICATION, 50):** Verify the first body h1 is selected, not later headings or text outside the body, and nested text is retained. Score 2 requires correct first-heading results across supplied pages; score 3 requires resilience to distracting later/outside headings.
