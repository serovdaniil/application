package bsuir.kaf.electroniki.core.controller;

/**
 * Multiple paths to the desired jsp that the teams work with.
 *
 * @author Daniil Serov
 */
public enum PagePaths {

    /**
     * Set of pages.
     */
    INDEX("/"),
    MAIN("/WEB-INF/jsp/Main.jsp"),
    AUTHORIZED_PAGE("/WEB-INF/jsp/AuthorizedPage.jsp"),
    FIRST_POWER_UNIT_PAGE("/WEB-INF/jsp/FirstPowerUnit.jsp"),
    SECOND_POWER_UNIT_PAGE("/WEB-INF/jsp/SecondPowerUnit.jsp"),
    TABLE_FOR_SAF_VAL("/WEB-INF/jsp/TableForSafVal.jsp"),
    EDIT_PAGE("/WEB-INF/jsp/EditCriteria.jsp");

    /**
     * Variable for command link selection.
     */
    private final String path;

    /**
     * Constructor for work.
     *
     * @param path variable for command link selection
     */
    PagePaths(String path) {
        this.path = path;
    }

    /**
     * Getting the path by name page.
     *
     * @return page path
     */
    public String getPath() {
        return path;
    }
}
