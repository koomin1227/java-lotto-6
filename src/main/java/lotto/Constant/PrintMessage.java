package lotto.Constant;

public enum PrintMessage {
    SECOND_PRINT_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    OTHER_PRINT_MESSAGE("%d개 일치 (%s원) - %d개\n");

    private final String message;

    PrintMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
