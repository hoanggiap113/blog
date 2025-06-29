package com.blog.util;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Tiện ích tránh NullPointerException khi lấy dữ liệu từ object.
 */
public class NullSafeUtil {

    /**
     * Lấy giá trị từ object nếu không null, ngược lại trả về null.
     *
     * @param input object đầu vào
     * @param mapper function để lấy giá trị từ object
     * @return giá trị lấy được hoặc null nếu input null hoặc xảy ra NullPointerException
     */
    public static <T, R> R getOrNull(T input, Function<T, R> mapper) {
        if (input == null || mapper == null) {
            return null;
        }
        try {
            return mapper.apply(input);
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Lấy giá trị từ object nếu không null, ngược lại trả về giá trị mặc định.
     *
     * @param input object đầu vào
     * @param mapper function để lấy giá trị từ object
     * @param defaultValue giá trị mặc định nếu input null hoặc xảy ra NullPointerException
     * @return giá trị lấy được hoặc defaultValue
     */
    public static <T, R> R getOrDefault(T input, Function<T, R> mapper, R defaultValue) {
        if (input == null || mapper == null) {
            return defaultValue;
        }
        try {
            return mapper.apply(input);
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    /**
     * Lấy giá trị từ Supplier (thường dùng cho getter lồng nhiều cấp), nếu có lỗi NullPointerException thì trả về giá trị mặc định.
     *
     * @param supplier supplier để lấy dữ liệu
     * @param defaultValue giá trị mặc định nếu xảy ra NullPointerException
     * @return giá trị lấy được hoặc defaultValue
     */
    public static <R> R getFromSupplierOrDefault(Supplier<R> supplier, R defaultValue) {
        if (supplier == null) {
            return defaultValue;
        }
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }
}
