/**
 * @author Janvier Zagabe
 */
package arrayJSPrototype;

class ArrayJSPrototype<T> implements PrototypeProps<T> {
    private Object[] arr = new Object[] {};

    /**
     * Pushes a new item into the array above
     */
    public void push(T newValue) {
        Object[] arr1 = new Object[arr.length + 1];

        arr1[arr.length] = newValue;

        int count = 0;

        while (count < arr.length) {
            arr1[count] = arr[count];
            count++;
        }
        setNewArray(arr1);
    }

    public void pop() {
        Object[] newArray = new Object[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                newArray[i] = arr[i];
            }
        }
        arr = new Object[newArray.length];
        setNewArray(newArray);
    }

    public Object get(int i) {
        return arr[i];
    }

    public void set(int i, T newValue) {
        try {
            arr[i] = newValue;
        } catch (ArrayStoreException e) {
            throw new IllegalStateException(e);
        }
    }

    private void setNewArray(Object[] arr) {
        this.arr = arr;
    }

    public int size() {
        return arr.length - 1;
    }

    private Object[] push(Object num, Object[] arr) {

        Object[] newArray = new Object[arr.length + 1];

        newArray[arr.length] = num;

        int count = 0;
        while (count < arr.length) {
            newArray[count] = arr[count];
            count++;
        }
        return newArray;
    }

    /**
     * @param index       starting index where the deletion will start
     * @param deleteCount the number of items to be removed
     */
    public void deleteFrom(int index, int deleteCount) {
        for (int i = 0; i < arr.length; i++) {

            int count = 0;
            while (i >= index && count < (deleteCount + index - 1)) {
                arr = removeToReset(i, arr);
                count++;
            }
        }
    }

    /**
     * Now we need to extends the new array size so we can add/push new items
     * anything that comes inside rest
     */
    public void update(Object... rest) {
        for (int i = 0; i < rest.length; i++) {
            if (rest[i] != null) {
                arr = push(rest[i], arr);
            }
        }
    }

    public void splice(int index, int deleteCount, Object... rest) {
        try {
            // Just delete when the rest[] is empty
            if (rest.length == 0) {
                deleteFrom(index, deleteCount);
            }

            else if (hasNewItems(rest)) {

                deleteFrom(index, deleteCount);

                update(rest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean hasNewItems(Object[] array) {
        if (array.length != 0) {
            return true;
        }
        return false;
    }

    public Boolean isEmpty() {
        if (this.arr.length == 0) {
            return true;
        }
        return false;
    }

    public Boolean includes(T item) {
        Boolean isIncluded = false;

        for (Object obj : arr) {
            if (obj.equals(item)) {
                isIncluded = true;
                break;
            }
        }
        return isIncluded;
    }

    public void delete(int index) {
        Object[] newArray = new Object[arr.length - 1];

        try {
            for (int i = 0; i <= arr.length; i++) {
                if (i != index) {
                    newArray[i] = arr[i];
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        arr = newArray;
    }

    @SuppressWarnings("unchecked")
    public Object[] removeToReset(int index, Object[] arr) {
        Object[] newArray = {};
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArray = push(arr[i], newArray);
            }
        }
        return newArray;
    }

    public Filter filter() {
        return new Filter<Object>() {

            public Object thisArg = this;

            @Override
            public void callBack(Object value, int index, Object[] array) {

            }
        };
    }
}

interface Filter<T> {
    public void callBack(T value, int index, T[] array);

    public Object thisArg = new Object();
}
