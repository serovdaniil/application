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
    DIAGRAM_FOR_SAF_VAL("/WEB-INF/jsp/DiagramForSafVal.jsp"),
    EDIT_CRITERIA("/WEB-INF/jsp/EditCriteria.jsp"),

    THIRD_SECTION("/WEB-INF/jsp/ThirdSection.jsp"),
    THIRD_SECTION_FIRST_UNIT("/WEB-INF/jsp/ThirdSectionFirstUnit.jsp"),
    THIRD_SECTION_SECOND_UNIT("/WEB-INF/jsp/ThirdSectionSecondUnit.jsp"),
    THIRD_SECTION_FIRST_UNIT_IDENTIFICATION_AND_PROGNOSIS("/WEB-INF/jsp/ThirdSectionFirstUnitIdentificationAndPrognosis.jsp"),
    THIRD_SECTION_SECOND_UNIT_IDENTIFICATION_AND_PROGNOSIS("/WEB-INF/jsp/ThirdSectionSecondUnitIdentificationAndPrognosis.jsp"),
    TABLE_FOR_TREND("/WEB-INF/jsp/TableForTrend.jsp"),
    DIAGRAM_FOR_TREND("/WEB-INF/jsp/DiagramForTrend.jsp"),
    SYS_EQUIP("/WEB-INF/jsp/SysEquip.jsp"),
    EDIT_SYS_EQUIP("/WEB-INF/jsp/EditSysEquip.jsp"),
    TABLE_FOR_CUR_STATUS("/WEB-INF/jsp/TableForCurSystem.jsp"),
    DIAGRAM_FOR_CUR_STATUS("/WEB-INF/jsp/DiagramForCurStatus.jsp"),

    EDIT_TREND("/WEB-INF/jsp/EditTrend.jsp");

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
