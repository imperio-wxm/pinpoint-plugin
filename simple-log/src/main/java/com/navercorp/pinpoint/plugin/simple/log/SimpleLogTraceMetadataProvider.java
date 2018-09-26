package com.navercorp.pinpoint.plugin.simple.log;

import com.navercorp.pinpoint.common.trace.TraceMetadataProvider;
import com.navercorp.pinpoint.common.trace.TraceMetadataSetupContext;

public class SimpleLogTraceMetadataProvider implements TraceMetadataProvider {

    @Override
    public void setup(TraceMetadataSetupContext context) {
        context.addServiceType(SimpleLogConstants.SERVICE_TYPE);
        context.addAnnotationKey(SimpleLogConstants.ANNOTATION_KEY_INFO);
    }
}
