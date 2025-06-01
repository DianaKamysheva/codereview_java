package Lab3.ru.kamysheva.ways;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Представляет город с возможностью добавления путей до других городов.
 */
public class City {
    /** Название города. */
    private final String name;

    /** Список путей из этого города в другие города. */
    private LinkedList<Path> paths;

    /**
     * Создает город с указанным названием.
     *
     * @param name название города
     */
    public City(String name) {
        this.name = name;
        this.paths = new LinkedList<>();
    }

    /**
     * Создает город с указанным названием и списком путей.
     *
     * @param name название города
     * @param paths список путей из города
     */
    public City(String name, LinkedList<Path> paths) {
        this.name = name;
        this.paths = new LinkedList<>();
        for (Path path : paths) {
            if (!hasPathTo(path.getDestination())) {
                this.paths.add(path);
            }
        }
    }

    /**
     * Устанавливает пути из города.
     *
     * @param paths массив путей для установки
     */
    public void setPath(Path[] paths) {
        this.paths = new LinkedList<>();
        for (Path path : paths) {
            if (!hasPathTo(path.getDestination())) {
                this.paths.add(path);
            }
        }
    }

    /**
     * Возвращает название города.
     *
     * @return название города
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает список путей из города.
     *
     * @return список путей
     */
    public LinkedList<Path> getPaths() {
        return new LinkedList<>(paths);
    }

    /**
     * Проверяет, существует ли путь до указанного города.
     *
     * @param destination город назначения
     * @return true, если путь существует, иначе false
     */
    public boolean hasPathTo(City destination) {
        for (Path path : paths) {
            if (path.getDestination().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет путь до города назначения с указанной стоимостью.
     *
     * @param destination город назначения
     * @param cost стоимость пути
     */
    public void addPath(City destination, int cost) {
        if (!hasPathTo(destination)) {
            paths.add(new Path(destination, cost));
        }
    }

    /**
     * Удаляет путь до указанного города назначения.
     *
     * @param destination город назначения
     */
    public void removePath(City destination) {
        paths.removeIf(path -> path.getDestination().equals(destination));
    }

    /**
     * Сравнивает этот город с другим объектом на равенство.
     *
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return Objects.equals(paths, city.paths);
    }

    /**
     * Возвращает хеш-код города.
     *
     * @return хеш-код города
     */
    @Override
    public int hashCode() {
        return Objects.hash(paths);
    }

    /**
     * Возвращает строковое представление города и его путей.
     *
     * @return строковое представление города
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + ": {");
        for (Path path : paths) {
            result.append(path.toString()).append(", ");
        }
        if (result.length() > name.length() + 3) {
            result.delete(result.length() - 2, result.length());
        }
        return result.append("}").toString();
    }
}