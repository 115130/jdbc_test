package chinasofti.util;

public interface Constrant {
    String driver = ConfigureManager.getInstance().getValue("driver");
    String url = ConfigureManager.getInstance().getValue("url");
    String name = ConfigureManager.getInstance().getValue("name");
    String pwd = ConfigureManager.getInstance().getValue("pwd");
}
