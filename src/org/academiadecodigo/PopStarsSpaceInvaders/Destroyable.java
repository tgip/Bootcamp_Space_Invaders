package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;

public interface Destroyable {
    void destroy(GenericBadGuy target);
    boolean isDestroyed();
    void hit();
}
