package com.navercorp.pinpoint.plugin.simple.log;

import com.navercorp.pinpoint.common.trace.AnnotationKey;
import com.navercorp.pinpoint.common.trace.AnnotationKeyFactory;
import com.navercorp.pinpoint.common.trace.ServiceType;
import com.navercorp.pinpoint.common.trace.ServiceTypeFactory;

public class SimpleLogConstants {

    public SimpleLogConstants() {
    }

    public static final String SCOPE = "SIMPLELOG_SCOPE";

    /**
     * 插件身份定义
     */
    public static final ServiceType SERVICE_TYPE = ServiceTypeFactory.of(1998, "SIMPLE_LOG");

    /**
     * pinpoint追踪信息中web上显示的属性的定义
     */
    public static final AnnotationKey ANNOTATION_KEY_INFO = AnnotationKeyFactory.of(9998, "simple.log.info", com.navercorp.pinpoint.common.trace.AnnotationKeyProperty.VIEW_IN_RECORD_SET);
}
