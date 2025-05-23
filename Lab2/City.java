package Lab2;

import java.util.ArrayList;

class City {
    private String name;
    private ArrayList<Route> routes;

    // Конструктор для создания города только с именем
    public City(String name) {
        setName(name);
        this.routes = new ArrayList<>();
    }
    // Конструктор для создания города с именем и набором путей
    public City(String name, ArrayList routes) {
        setName(name);
        this.routes = routes;
    }

    // Добавление маршрута
    public void addRoute(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Пункт назначения не может быть null.");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Стоимость маршрута не может быть отрицательной или равна 0.");
        }
        routes.add(new Route(destination, cost));
    }

    // Установка имени с проверкой
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя города не может быть пустым или null.");
        }
        this.name = name;
    }

    // Текстовое представление города
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Город: ").append(name).append("\n");
        if (!routes.isEmpty()) {
            sb.append("Маршруты:\n");
            for (Route route : routes) {
                sb.append(route.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}
 // Внутренний класс для представления маршрута


class Route {
    private City destination;
    private int cost;

    // Конструктор добавления путей
    public Route(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Пункт назначения маршрута не может быть null.");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Стоимость маршрута не может быть отрицательной или равна 0.");
        }
        this.destination = destination;
        this.cost = cost;
    }
    }