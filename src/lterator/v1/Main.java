package lterator.v1;


/**
 * @author ������
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
 * ������� ���������Ǳ߽����� ���Զ�̬��չ
 */
class ArrayList_ {
    Object[] objects = new Object[10];
    private int index = 0;

    public void add(Object o) {
        //���index������������ĳ��� �Ϳ��Զ������С������չ һ��������һ��Ĵ�С Ҳ����*2
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];//�����������չ ��ԭ���鸳��������
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            //arrayCopy( arr1, 2, arr2, 5, 10);
            //
            //��˼��;��arr1�����������Ϊ2��Ԫ�ؿ�ʼ, ���Ƶ�����arr2�������Ϊ5��λ��, ���Ƶ�Ԫ�ظ���Ϊ10��.
            objects = newObjects;//����������


        }
        objects[index] = o;//�������
        index++;
    }

    public int size() {
        return index;
    }
}

