package comGameModel.cor;

import comGameModel.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class ColliderChain {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider c) {
        colliders.add(c);
    }


    public boolean collide(GameObject o1, GameObject o2) {//链条自己做碰撞即可
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1,o2)){
                return false;

            }
        }
        return true;
    }
}
