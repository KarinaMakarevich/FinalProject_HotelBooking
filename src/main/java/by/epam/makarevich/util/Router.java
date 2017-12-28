package by.epam.makarevich.util;

import by.epam.makarevich.type.RouterType;

public class Router {
    private String path;
    private RouterType type;

    public Router() {
        this.type = RouterType.FORWARD;
    }

    public Router(String path, RouterType type) {
        this.path = path;
        this.type = type;

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RouterType getType() {
        return type;
    }

    public void setType(RouterType type) {
        this.type = type;
    }
}
