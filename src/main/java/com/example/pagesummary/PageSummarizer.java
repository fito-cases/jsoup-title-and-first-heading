package com.example.pagesummary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/** Summarizes a complete HTML page that the caller already holds as a string. */
public final class PageSummarizer {

    public PageSummary summarize(String html) {
        Document page = Jsoup.parse(html);
        Element heading = page.body().selectFirst("h1");
        return new PageSummary(page.title(), heading == null ? "" : heading.text());
    }
}
