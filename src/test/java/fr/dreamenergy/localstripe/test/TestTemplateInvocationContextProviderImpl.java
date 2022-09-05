package fr.dreamenergy.localstripe.test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public class TestTemplateInvocationContextProviderImpl implements TestTemplateInvocationContextProvider {

	private final List<StripeTestCase> stripeTestCases;

	
	public TestTemplateInvocationContextProviderImpl(List<StripeTestCase> parameters) {
		super();
		this.stripeTestCases = parameters;
	}

	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		return true;
	}

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		return stripeTestCases.stream().map(p -> invocationContext(p));
	}
	
	private TestTemplateInvocationContext invocationContext(StripeTestCase stripeTestCase) {
        return new TestTemplateInvocationContext() {

            @Override
            public String getDisplayName(int invocationIndex) {
                return stripeTestCase.displayName();
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return Collections.singletonList(new ParameterResolver() {

                    @Override
                    public boolean supportsParameter(
                            ParameterContext parameterContext,
                            ExtensionContext extensionContext) {
                        return parameterContext.getParameter().getType().equals(
                                StripeTestCase.class);
                    }

                    @Override
                    public Object resolveParameter(ParameterContext parameterContext,
                            ExtensionContext extensionContext) {
                        return stripeTestCase;
                    }
                });
            }
        };
    }

}
