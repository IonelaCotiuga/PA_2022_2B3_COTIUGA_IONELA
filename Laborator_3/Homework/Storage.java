package lab3;

public interface Storage {
    int getStorageCapacity();

    default long returnByte(int capacityInGB){
        return capacityInGB* 1024L;
    }
}

