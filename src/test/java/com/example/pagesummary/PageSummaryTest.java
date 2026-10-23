package com.example.pagesummary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PageSummaryTest {

    private static final String RELEASE_NOTES = """
            <!DOCTYPE html>
            <html>
              <head>
                <title>Release notes</title>
                <meta name="description" content="h1 not a body heading">
              </head>
              <body>
                <nav><a href="/">Home</a></nav>
                <main>
                  <h1>Welcome <em>back</em></h1>
                  <p>What changed in this release.</p>
                  <h1>Not first</h1>
                </main>
              </body>
            </html>
            """;

    private static final String GUIDE = """
            <!DOCTYPE html>
            <html>
              <head><title>  R&amp;D Guide  </title></head>
              <body>
                <section>
                  <div><h1>Getting <strong>started</strong> with the lab</h1></div>
                  <h2>Safety</h2>
                </section>
              </body>
            </html>
            """;

    private final PageSummarizer summarizer = new PageSummarizer();

    @Test
    void returnsTitleForSuppliedPages() {
        assertEquals("Release notes", summarizer.summarize(RELEASE_NOTES).title());
        assertEquals("R&D Guide", summarizer.summarize(GUIDE).title());
    }

    @Test
    void summarizesSuppliedPages() {
        assertEquals(new PageSummary("Release notes", "Welcome back"), summarizer.summarize(RELEASE_NOTES));
        assertEquals(new PageSummary("R&D Guide", "Getting started with the lab"), summarizer.summarize(GUIDE));
    }
}
