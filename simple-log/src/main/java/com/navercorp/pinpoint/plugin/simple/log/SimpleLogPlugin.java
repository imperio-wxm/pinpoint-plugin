package com.navercorp.pinpoint.plugin.simple.log;

import com.navercorp.pinpoint.bootstrap.instrument.*;
import com.navercorp.pinpoint.bootstrap.instrument.transformer.TransformTemplate;
import com.navercorp.pinpoint.bootstrap.instrument.transformer.TransformTemplateAware;
import com.navercorp.pinpoint.bootstrap.logging.PLogger;
import com.navercorp.pinpoint.bootstrap.logging.PLoggerFactory;
import com.navercorp.pinpoint.bootstrap.plugin.ProfilerPlugin;
import com.navercorp.pinpoint.bootstrap.plugin.ProfilerPluginSetupContext;

public class SimpleLogPlugin implements ProfilerPlugin, TransformTemplateAware {
    private final PLogger logger = PLoggerFactory.getLogger(this.getClass());

    private TransformTemplate transformTemplate;

    @Override
    public void setTransformTemplate(TransformTemplate transformTemplate) {
        this.transformTemplate = transformTemplate;
    }

    @Override
    public void setup(ProfilerPluginSetupContext context) {
        addBasicTransformer();
        logger.info("Simple Log Plugin start!");
    }

    private void addBasicTransformer() {
        transformTemplate.transform("ch.qos.logback.classic.Logger", (instrumentor, classLoader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
            InstrumentClass target = instrumentor.getInstrumentClass(classLoader, className, classfileBuffer);
            for (InstrumentMethod instrumentMethod : target.getDeclaredMethods(MethodFilters.name("info"))) {
                instrumentMethod.addScopedInterceptor("com.navercorp.pinpoint.plugin.simple.log.interceptor.SimpleLogInterceptor", SimpleLogConstants.SCOPE);
            }
            return target.toBytecode();
        });
    }
}
