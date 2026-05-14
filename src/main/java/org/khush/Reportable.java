package org.khush;

public interface Reportable {

    /**
     * Build a text report that lists items with the given status
     */
    String reportItemsByStatus(Item.Status status);

    /**
     * Build a text report of all items. Items are grouped in sections,
     * one section for each possible status.
     */
    String reportAllItemsByStatusSections();

    /**
     * Build a text report that lists every user in the library.
     * Each user is written on its own row.
     */
    String reportAllUsers();
}
