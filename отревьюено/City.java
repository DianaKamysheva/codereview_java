package отревьюено;

import java.util.ArrayList;

/**
 * Представляет город с названием и списком маршрутов.
 */
public class City {
  private String name;
  private ArrayList<Route> routes;

  /**
   * Создает город с именем.
   *
   * @param name имя города
   */
  public City(String name) {
    setName(name);
    this.routes = new ArrayList<>();
  }

  /**
   * Создает город с названием и списком маршрутов.
   *
   * @param name имя города
   * @param routes список путей
   */
  public City(String name, ArrayList<Route> routes) {
    setName(name);
    this.routes = routes;
  }

  /**
   * Добавляет маршрут в город.
   *
   * @param destination город назначения
   * @param cost стоимость маршрута
   * @throws IllegalArgumentException если пункт назначения равен нулю или стоимость не положительна
   */
  public void addRoute(City destination, int cost) {
    if (destination == null) {
      throw new IllegalArgumentException("Место назначения не может быть null.");
    }
    if (cost <= 0) {
        throw new IllegalArgumentException("Стоимость маршрута должна быть положительным числом.");
    }
    routes.add(new Route(destination, cost));
  }

  /**
  * Устанавливает название города.
  *
  * @param name название для установки
  * @throws IllegalArgumentException если название равно null или пусто
  */
  public void setName(String name) {
   if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Название города не может быть пустым или null.");
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  /**
   * Возвращает строковое представление City.
   *
   * @return строковое представление City
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Город: ").append(name).append("\n");
    if (!routes.isEmpty()) {
      sb.append("Пути:\n");
      for (Route route : routes) {
        sb.append(route.toString()).append("\n");
      }
    }
    return sb.toString();
  }
}

/**
 * Представляет маршрут с городом назначения и стоимостью.
 */
class Route {
  private City destination;
  private int cost;

  /**
   * Создает маршрут с пунктом назначения и стоимостью.
   *
   * @param destination город назначения
   * @param cost стоимость маршрута
   * @throws IllegalArgumentException если пункт назначения равен null или стоимость не положительна
   */
  public Route(City destination, int cost) {
    if (destination == null) {
      throw new IllegalArgumentException("Пункт назначения маршрута не может быть пустым.");
    }
    if (cost <= 0) {
      throw new IllegalArgumentException("Стоимость маршрута должна быть положительным числом.");
    }
    this.destination = destination;
    this.cost = cost;
  }

  /**
   * Возвращает строковое представление маршрута.
   *
   * @return строковое представление маршрута
   */
  @Override
  public String toString() {
    return "Пункт назначения: " + destination.getName() + ", Цена: " + cost;
  }

  /**
   * Получает название города назначения.
   *
   * @return название города назначения
   */
  public String getName() {
    return destination.getName();
  }
}