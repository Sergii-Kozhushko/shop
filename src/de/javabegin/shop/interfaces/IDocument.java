package de.javabegin.shop.interfaces;

import java.util.Calendar;

public interface IDocument {
    Calendar getDateTimeCreation();
    IEmployee getAuthor();
}
