package Lab3.ru.kamysheva.ways;

import java.util.Objects;

/**
 * Представляет путь до города назначения с определенной стоимостью.
 */
public class Path {
    /** Город назначения. */
    private final City destination;

    /** Стоимость пути. */
    private final int cost;

    /**
     * Создает путь до указанного города назначения с заданной стоимостью.
     *
     * @param destination город назначения
     * @param cost стоимость пути
     */
    public Path(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    /**
     * Возвращает город назначения.
     *
     * @return город назначения
     */
    public City getDestination() {
        return destination;
    }

    /**
     * Возвращает стоимость пути.
     *
     * @return стоимость пути
     */
    public int getCost() {
        return cost;
    }

    /**
     * Сравнивает этот путь с другим объектом на равенство.
     *
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Path path = (Path) obj;
        return cost == path.cost && Objects.equals(destination.getName(), path.destination.getName());
    }

    /**
     * Возвращает хеш-код пути.
     *
     * @return хеш-код пути
     */
    @Override
    public int hashCode() {
        return Objects.hash(destination, cost);
    }

    /**
     * Возвращает строковое представление пути.
     *
     * @return строковое представление пути
     */
    @Override
    public String toString() {
        return "(" + destination.getName() + ": " + cost + ")";
    }
}