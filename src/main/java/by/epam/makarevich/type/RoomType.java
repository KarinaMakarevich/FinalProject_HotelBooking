package by.epam.makarevich.type;

public enum RoomType {
    BALCONY_ROOM("Комната с балконом"),
    DUPLEX("Дюплекс"),
    STANDARD("Стандарт"),
    STUDIO("Студия"),
    SUITE("Номер повышенной комфортности"),
    MINI_SUITE("Номер улучшенной категории");

    RoomType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public static RoomType findByName(String name) throws EnumConstantNotPresentException {
        for (RoomType roomType : RoomType.values()) {
            if (roomType.getName().equals(name)) {
                return roomType;
            }
        }
        throw new EnumConstantNotPresentException(RoomType.class, "Error with searching room type");
    }
}
