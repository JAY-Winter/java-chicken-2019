package view;

import domain.menu.Menu;
import domain.table.Table;

import java.util.List;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printMainDisplay() {
        System.out.println("## 메인화면");
        System.out.println(""
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료\n");
    }

    // 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시한다
    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printStartPay(int tableNumber) {
        System.out.println("##" + tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printTotalPaymentAmount(int totalPaymentAmount) {
        System.out.println("##최종 결제할 금액");
        System.out.println(totalPaymentAmount + "원");
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
