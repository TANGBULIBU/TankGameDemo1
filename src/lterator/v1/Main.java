package lterator.v1;


/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));

        }
        System.out.println(list.size());
    }
}

/**
 * 相比数组 容器不考虑边界问题 可以动态拓展
 */
class ArrayList_ {
    Object[] objects = new Object[10];
    private int index = 0;

    public void add(Object o) {
        //如果index等于现在数组的长度 就可以对数组大小进行拓展 一般是增加一半的大小 也就是*2
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];//新数组进行拓展 将原数组赋给新数组
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            //arrayCopy( arr1, 2, arr2, 5, 10);
            //
            //意思是;将arr1数组里从索引为2的元素开始, 复制到数组arr2里的索引为5的位置, 复制的元素个数为10个.
            objects = newObjects;//赋给新数组


        }
        objects[index] = o;//添加数据
        index++;
    }

    public int size() {
        return index;
    }
}

