package fr.dreamenergy.localstripe.repository;

import org.springframework.stereotype.Component;

import com.stripe.model.PaymentIntent;

@Component
public class PaymentIntentRepository extends AbstractRepository<PaymentIntent>{

}
