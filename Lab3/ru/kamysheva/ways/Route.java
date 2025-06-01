package Lab3.ru.kamysheva.ways;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Представляет маршрут между начальным и конечным городом.
 */
public class Route {
    /** Начальный город маршрута. */
    private City startCity;

    /** Конечный город маршрута. */
    private City endCity;

    /**
     * Создает маршрут между начальным и конечным городом.
     *
     * @param startCity начальный город
     * @param endCity конечный город
     * @throws IllegalArgumentException если начальный или конечный город равен null
     */
    public Route(City startCity, City endCity) {
        if (startCity == null || endCity == null) {
            throw new IllegalArgumentException("Начальный и конечный города не должны быть null");
        }
        this.startCity = startCity;
        this.endCity = endCity;
    }

    /**
     * Устанавливает начальный город маршрута.
     *
     * @param startCity начальный город
     * @throws IllegalArgumentException если начальный город равен null
     */
    public void setStartCity(City startCity) {
        if (startCity == null) {
            throw new IllegalArgumentException("Начальный город не должен быть null");
        }
        this.startCity = startCity;
    }

    /**
     * Устанавливает конечный город маршрута.
     *
     * @param endCity конечный город
     * @throws IllegalArgumentException если конечный город равен null
     */
    public void setEndCity(City endCity) {
        if (endCity == null) {
            throw new IllegalArgumentException("Конечный город не должен быть null");
        }
        this.endCity = endCity;
    }

    /**
     * Возвращает начальный город маршрута.
     *
     * @return начальный город
     */
    public City getStartCity() {
        return startCity;
    }

    /**
     * Возвращает конечный город маршрута.
     *
     * @return конечный город
     */
    public City getEndCity() {
        return endCity;
    }

    /**
     * Возвращает маршрут в виде массива городов.
     *
     * @return массив городов, представляющий маршрут
     */
    public City[] getRoute() {
        List<City> route = new ArrayList<>();
        findRoute(startCity, endCity, new LinkedList<>(), route);
        return route.toArray(new City[0]);
    }

    /**
     * Рекурсивно ищет маршрут между текущим городом и городом назначения.
     *
     * @param current текущий город
     * @param destination город назначения
     * @param visited список посещенных городов
     * @param route текущий маршрут
     * @return true, если маршрут найден, иначе false
     */
    private boolean findRoute(City current, City destination, LinkedList<City> visited, List<City> route) {
        visited.add(current);
        route.add(current);

        if (current.equals(destination)) {
            return true;
        }

        for (Path path : current.getPaths()) {
            City nextCity = path.getDestination();
            if (!visited.contains(nextCity)) {
                if (findRoute(nextCity, destination, visited, route)) {
                    return true;
                }
            }
        }

        route.remove(route.size() - 1);
        visited.remove(current);
        return false;
    }

    /**
     * Возвращает строковое представление маршрута.
     *
     * @return строковое представление маршрута
     */
    @Override
    public String toString() {
        City[] route = getRoute();
        if (route.length == 0) {
            return "Маршрут не найден";
        }

        StringBuilder sb = new StringBuilder();
        for (City city : route) {
            sb.append(city.getName()).append(" -> ");
        }
        sb.delete(sb.length() - 4, sb.length()); // Удаляет последний " -> "
        return sb.toString();
    }
}