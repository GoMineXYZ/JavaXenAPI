/*
 * Copyright (c) 2016, Mazen Kotb, mazenkotb@gmail.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package xyz.mkotb.xenapi.model;

import java.util.Date;

public class LastPost {
    private final int id;
    private final Date date;
    private final int userId;
    private final String username;
    private final String title;

    public LastPost(int id, long date, int userId, String username, String title) {
        this.id = id;
        this.date = new Date(date);
        this.userId = userId;
        this.username = username;
        this.title = title;
    }

    public int id() {
        return id;
    }

    public Date date() {
        return date;
    }

    public int userId() {
        return userId;
    }

    public String username() {
        return username;
    }

    public String title() {
        return title;
    }
}
