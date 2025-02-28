/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.js.runtime;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.graalvm.collections.EconomicMap;
import org.graalvm.collections.EconomicSet;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.js.runtime.util.BufferUtil;

/**
 * Utility class for calls to library methods that require a {@link TruffleBoundary}.
 */
public final class Boundaries {

    private Boundaries() {
        // don't instantiate this
    }

    @TruffleBoundary
    public static String javaToString(Object value) {
        return value.toString();
    }

    @TruffleBoundary
    public static String stringValueOf(long l) {
        return String.valueOf(l);
    }

    @TruffleBoundary
    public static String stringValueOf(int i) {
        return String.valueOf(i);
    }

    @TruffleBoundary
    public static String stringValueOf(double d) {
        return String.valueOf(d);
    }

    @TruffleBoundary
    public static String stringValueOf(Object o) {
        return String.valueOf(o);
    }

    @TruffleBoundary(allowInlining = true)
    public static String stringValueOf(char[] chars) {
        return String.valueOf(chars);
    }

    @TruffleBoundary
    public static Integer integerValueOf(String s) {
        return Integer.valueOf(s);
    }

    @TruffleBoundary
    public static Double doubleValueOf(String s) {
        return Double.valueOf(s);
    }

    @TruffleBoundary
    public static Float floatValueOf(String s) {
        return Float.valueOf(s);
    }

    @TruffleBoundary
    public static Long longValueOf(String s) {
        return Long.valueOf(s);
    }

    @TruffleBoundary(allowInlining = true)
    public static String builderToString(StringBuilder res) {
        return res.toString();
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, int intValue) {
        sb.append(intValue);
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, long longValue) {
        sb.append(longValue);
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, CharSequence seq) {
        sb.append(seq);
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, String str) {
        sb.append(str);
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, char chr) {
        sb.append(chr);
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, CharSequence seq, int start, int end) {
        sb.append(seq, start, end);
    }

    @TruffleBoundary(allowInlining = true)
    public static void builderAppend(StringBuilder sb, String str, int start, int end) {
        sb.append(str, start, end);
    }

    @TruffleBoundary
    public static char charAt(CharSequence cs, int idx) {
        return cs.charAt(idx);
    }

    @TruffleBoundary
    public static CharSequence subSequence(CharSequence s, int begin, int end) {
        return s.subSequence(begin, end);
    }

    @TruffleBoundary
    public static CharSequence subSequence(CharSequence s, int begin) {
        return s.subSequence(begin, s.length());
    }

    @TruffleBoundary
    public static String charSequenceToString(CharSequence value) {
        return value.toString();
    }

    @TruffleBoundary(allowInlining = true)
    public static String substring(String s, int begin, int end) {
        return s.substring(begin, end);
    }

    @TruffleBoundary(allowInlining = true)
    public static String substring(String s, int begin) {
        return s.substring(begin);
    }

    @TruffleBoundary
    public static String stringFormat(String format, Object... params) {
        return String.format(format, params);
    }

    // a TruffleBoundary is NOT need for indexOf, as this is intrinisfied by GraalVM.
    public static int stringIndexOf(String s, String pattern) {
        return s.indexOf(pattern);
    }

    public static int stringIndexOf(String s, String pattern, int startPos) {
        return s.indexOf(pattern, startPos);
    }

    public static int stringIndexOf(String s, char pattern) {
        return s.indexOf(pattern);
    }

    public static int stringIndexOf(String s, char pattern, int startPos) {
        return s.indexOf(pattern, startPos);
    }

    @TruffleBoundary(allowInlining = true)
    public static int stringLastIndexOf(String s, String pattern) {
        return s.lastIndexOf(pattern);
    }

    @TruffleBoundary(allowInlining = true)
    public static int stringLastIndexOf(String s, String pattern, int startPos) {
        return s.lastIndexOf(pattern, startPos);
    }

    @TruffleBoundary(allowInlining = true)
    public static int stringLastIndexOf(String s, char pattern) {
        return s.lastIndexOf(pattern);
    }

    @TruffleBoundary(allowInlining = true)
    public static int stringLastIndexOf(String s, char pattern, int startPos) {
        return s.lastIndexOf(pattern, startPos);
    }

    @TruffleBoundary(allowInlining = true)
    public static int stringCompareTo(String a, String b) {
        return a.compareTo(b);
    }

    @TruffleBoundary(allowInlining = true)
    public static boolean stringStartsWith(String s, String pattern) {
        return s.startsWith(pattern);
    }

    @TruffleBoundary(allowInlining = true)
    public static boolean stringStartsWith(String s, String pattern, int startPos) {
        return s.startsWith(pattern, startPos);
    }

    @TruffleBoundary(allowInlining = true)
    public static boolean stringEndsWith(String s, String pattern) {
        return s.endsWith(pattern);
    }

    @TruffleBoundary(allowInlining = true)
    public static int stringCodePointAt(String s, int pos) {
        return s.codePointAt(pos);
    }

    @TruffleBoundary(allowInlining = true)
    public static String stringConcat(String left, String right) {
        return left.concat(right);
    }

    @TruffleBoundary
    public static String stringToLowerCase(String s, Locale locale) {
        return s.toLowerCase(locale);
    }

    @TruffleBoundary
    public static String stringToUpperCase(String s, Locale locale) {
        return s.toUpperCase(locale);
    }

    @TruffleBoundary
    public static String stringReplaceAll(String s, String regex, String replacement) {
        return s.replaceAll(regex, replacement);
    }

    @TruffleBoundary
    public static boolean characterIsDigit(char ch) {
        return Character.isDigit(ch);
    }

    @TruffleBoundary
    public static boolean characterIsUpperCase(char ch) {
        return Character.isUpperCase(ch);
    }

    @TruffleBoundary
    public static boolean equals(Object a, Object b) {
        return a.equals(b);
    }

    @TruffleBoundary
    public static <K, V> Set<Map.Entry<K, V>> mapEntrySet(Map<K, V> map) {
        return map.entrySet();
    }

    @TruffleBoundary
    public static <K, V> V mapPut(Map<K, V> map, K key, V value) {
        return map.put(key, value);
    }

    @TruffleBoundary
    public static <K, V> V mapPutIfAbsent(Map<K, V> map, K key, V value) {
        return map.putIfAbsent(key, value);
    }

    @TruffleBoundary
    public static <K, V> boolean mapContainsKey(Map<K, V> map, Object key) {
        return map.containsKey(key);
    }

    @TruffleBoundary
    public static <K, V> V mapGet(Map<K, V> map, Object key) {
        return map.get(key);
    }

    @TruffleBoundary
    public static <K, V> V mapRemove(Map<K, V> map, Object key) {
        return map.remove(key);
    }

    @TruffleBoundary
    public static <T> T listGet(List<T> list, int index) {
        return list.get(index);
    }

    @TruffleBoundary
    public static <T> void listSet(List<T> list, int index, T value) {
        list.set(index, value);
    }

    @TruffleBoundary
    public static <T> int listSize(List<T> list) {
        return list.size();
    }

    @TruffleBoundary
    public static <T> int listIndexOf(List<T> list, T element) {
        return list.indexOf(element);
    }

    @TruffleBoundary
    public static <T> void listAdd(List<T> list, T element) {
        list.add(element);
    }

    @TruffleBoundary
    public static <T> void listAddAll(List<T> list, List<T> addList) {
        list.addAll(addList);
    }

    @TruffleBoundary
    public static <T> boolean listContains(List<T> list, T element) {
        return list.contains(element);
    }

    @TruffleBoundary
    public static <T> Object[] listToArray(List<T> list) {
        return list.toArray();
    }

    @TruffleBoundary
    public static <T> boolean iteratorHasNext(Iterator<T> it) {
        return it.hasNext();
    }

    @TruffleBoundary
    public static <T> T iteratorNext(Iterator<T> it) {
        return it.next();
    }

    @TruffleBoundary
    public static <T> Iterator<T> iterator(Iterable<T> iterable) {
        return iterable.iterator();
    }

    @TruffleBoundary
    public static <T> EconomicSet<T> economicSetCreate() {
        return EconomicSet.create();
    }

    @TruffleBoundary
    public static <T> boolean economicSetAdd(EconomicSet<T> economicSet, T element) {
        return economicSet.add(element);
    }

    @TruffleBoundary
    public static <T> boolean economicSetContains(EconomicSet<T> economicSet, T element) {
        return economicSet.contains(element);
    }

    @TruffleBoundary
    public static <K, V> EconomicMap<K, V> economicMapCreate() {
        return EconomicMap.create();
    }

    @TruffleBoundary
    public static <K, V> V economicMapPut(EconomicMap<K, V> map, K key, V value) {
        return map.put(key, value);
    }

    @TruffleBoundary
    public static <K, V> boolean economicMapContainsKey(EconomicMap<K, V> map, K key) {
        return map.containsKey(key);
    }

    @TruffleBoundary
    public static <K, V> V economicMapGet(EconomicMap<K, V> map, K key) {
        return map.get(key);
    }

    @TruffleBoundary(allowInlining = true)
    public static byte[] byteBufferArray(ByteBuffer buffer) {
        return buffer.array();
    }

    @TruffleBoundary(allowInlining = true)
    public static void byteBufferPutSlice(ByteBuffer dst, int dstPos, ByteBuffer src, int srcPos, int srcLimit) {
        ByteBuffer slice = byteBufferSlice(src, srcPos, srcLimit);
        ByteBuffer dstDup = dst.duplicate();
        BufferUtil.asBaseBuffer(dstDup).position(dstPos);
        dstDup.put(slice);
    }

    @TruffleBoundary(allowInlining = true)
    public static ByteBuffer byteBufferSlice(ByteBuffer buf, int pos, int limit) {
        ByteBuffer dup = buf.duplicate();
        BufferUtil.asBaseBuffer(dup).position(pos).limit(limit);
        return dup.slice();
    }

    @TruffleBoundary(allowInlining = true)
    public static ByteBuffer byteBufferDuplicate(ByteBuffer buffer) {
        return buffer.duplicate();
    }
}
