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
package xyz.mkotb.xenapi;

import java.util.HashMap;
import java.util.Map;

public final class XenUtils {
    private XenUtils() {
    }

    // custom_field_1=custom_value_1,custom_field_2=custom_value_2
    public static Map<String, String> decodeMap(String value) {
        Map<String, String> map = new HashMap<>();
        String[] array = value.split(",");

        for (String s : array) {
            String[] entry = s.split(",", 2);
            map.put(entry[0], entry[1]);
        }

        return map;
    }

    public static String encodeMap(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();

        map.forEach((key, value) -> builder.append(key)
                .append('=').append(value).append(','));

        String encoded = builder.toString();
        return encoded.substring(0, encoded.length() - 1);
    }
}
