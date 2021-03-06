package pl.devoxx.aggregatr.aggregation;

import com.codahale.metrics.MetricRegistry;
import com.nurkiewicz.asyncretry.RetryExecutor;
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AggregationConfiguration {
    @Bean
    IngredientsAggregator ingredientsAggregator(ServiceRestClient serviceRestClient,
                                                RetryExecutor retryExecutor,
                                                IngredientsProperties ingredientsProperties,
                                                MetricRegistry metricRegistry) {
        return new IngredientsAggregator(serviceRestClient, retryExecutor, ingredientsProperties, metricRegistry);
    }

    @Bean
    IngredientsProperties ingredientsProperties() {
        return new IngredientsProperties();
    }
}

