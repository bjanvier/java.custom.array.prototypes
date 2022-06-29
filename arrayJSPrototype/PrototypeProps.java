package arrayJSPrototype;

public interface PrototypeProps<T> {
    public void push(T newValue);

    public void pop();

    public void set(int i, T newValue);

    public void splice(int index, int deleteCount, T... rest);

    public Boolean isEmpty();

    public void delete(int index);

    public T[] removeToReset(int index, T[] arr);

}
