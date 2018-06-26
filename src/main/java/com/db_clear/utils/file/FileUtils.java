package com.db_clear.utils.file;

import java.io.File;

import com.db_clear.utils.string.CharUtils;
import com.db_clear.utils.string.StringUtils;

/**
 * @title:TODO 文件工具类
 * @Description:
 * @author: tuhejie
 * @PackageName: com.thj.utils.file
 * @ClassName: FileUtils
 * @Date: 2018年6月14日 下午4:28:19
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

	/** 类Unix路径分隔符 */
	public static final char UNIX_SEPARATOR = CharUtils.SLASH;
	/** Windows路径分隔符 */
	public static final char WINDOWS_SEPARATOR = CharUtils.BACKSLASH;

	/**
	 * Deletes a file, never throwing an exception. If file is a directory, delete
	 * it and all sub-directories.
	 * <p>
	 * The difference between File.delete() and this method are:
	 * <ul>
	 * <li>A directory to be deleted does not have to be empty.</li>
	 * <li>No exceptions are thrown when a file or directory cannot be deleted.</li>
	 * </ul>
	 *
	 * @param file
	 *            file or directory to delete, can be {@code null}
	 * @return {@code true} if the file or directory was deleted, otherwise
	 *         {@code false}
	 *
	 */
	public static boolean deleteQuietly(final String filePath) {
		if (StringUtils.isBlank(filePath)) {
			return false;
		}
		File file = new File(filePath);
		return deleteQuietly(file);
	}

	/**
	 * 是否为Windows环境
	 * 
	 * @return 是否为Windows环境
	 * @since 3.0.9
	 */
	public static boolean isWindows() {
		return WINDOWS_SEPARATOR == File.separatorChar;
	}

}
