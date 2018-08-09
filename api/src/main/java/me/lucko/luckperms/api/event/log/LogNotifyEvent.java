/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.api.event.log;

import me.lucko.luckperms.api.Entity;
import me.lucko.luckperms.api.LogEntry;
import me.lucko.luckperms.api.event.Cancellable;
import me.lucko.luckperms.api.event.LuckPermsEvent;
import me.lucko.luckperms.api.event.Param;

import javax.annotation.Nonnull;

/**
 * Called when a log entry is about to be sent to specific notifiable object on
 * the platform.
 *
 * <p>This event is not called for players without the notify permission,
 * but is called for objects which are ignoring log notifications (called with
 * the cancelled flag set to true).</p>
 *
 * @since 4.1
 */
public interface LogNotifyEvent extends LuckPermsEvent, Cancellable {

    /**
     * Gets the log entry to be sent
     *
     * @return the log entry to be sent
     */
    @Nonnull
    @Param(0)
    LogEntry getEntry();

    /**
     * Gets where the log entry originated from.
     *
     * @return the origin of the log
     */
    @Nonnull
    @Param(1)
    Origin getOrigin();

    /**
     * Gets the object to be notified.
     *
     * @return the object to notify
     */
    @Nonnull
    @Param(2)
    Entity getNotifiable();

    /**
     * Represents where a log entry is from
     */
    enum Origin {

        /**
         * Marks a log entry which originated from the current server instance
         */
        LOCAL,

        /**
         * Marks a log entry which originated from an API call on the current server instance
         */
        LOCAL_API,

        /**
         * Marks a log entry which was sent to this server via the messaging service
         */
        REMOTE
    }

}
