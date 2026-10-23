package com.example.pagesummary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/** Summarizes a complete HTML page that the caller already holds as a string. */
public final class PageSummarizer {

    public PageSummary summarize(String html) {
        Document page = Jsoup.parse(html);
        // TODO: return the text of the first heading in the page's body.
        return new PageSummary(page.title(), "");
    }
}
