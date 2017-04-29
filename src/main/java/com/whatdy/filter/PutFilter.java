package com.whatdy.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

/**
 *  解决无法 接收PUT参数问题
 */
@Component
public class PutFilter extends HttpPutFormContentFilter {
}
