package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;

public interface Destroyable {
    void destroy(GameObject target);

    boolean isDestroyed();

    void hit();
}
