# Ticket: Page summary from supplied HTML

Reported by: the content team.

Our page-summary feature receives a complete HTML page as a string. It must return two pieces of text: the page title and the first `<h1>` inside the document body.

Some sample pages have nested elements in the body and multiple headings. The summary should reflect the page structure, not just a matching fragment of the input text. Everything is already in the supplied string; the feature must work without network access.
