/*
 * WorldGuard, a suite of tools for Minecraft
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldGuard team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldguard.internal.event.entity;

import com.sk89q.worldguard.internal.cause.Cause;
import com.sk89q.worldguard.internal.event.AbstractInteractEvent;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class AbstractEntityEvent extends AbstractInteractEvent {

    private final Location target;
    @Nullable
    private final Entity entity;

    /**
     * Create a new instance
     *
     * @param originalEvent the original event
     * @param causes a list of causes, where the originating causes are at the beginning
     * @param entity the target
     */
    protected AbstractEntityEvent(Event originalEvent, List<? extends Cause<?>> causes, Entity entity) {
        super(originalEvent, causes);
        checkNotNull(entity);
        this.target = entity.getLocation();
        this.entity = entity;
    }

    /**
     * Create a new instance
     *
     * @param originalEvent the original event
     * @param causes a list of causes, where the originating causes are at the beginning
     * @param target the target
     */
    protected AbstractEntityEvent(Event originalEvent, List<? extends Cause<?>> causes, Location target) {
        super(originalEvent, causes);
        checkNotNull(target);
        this.target = target;
        this.entity = null;
    }

    /**
     * Get the target location being affected.
     *
     * @return a location
     */
    public Location getTarget() {
        return target;
    }


    /**
     * Get the target entity being affected.
     *
     * @return a entity
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

}
