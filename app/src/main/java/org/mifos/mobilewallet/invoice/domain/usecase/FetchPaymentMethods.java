package org.mifos.mobilewallet.invoice.domain.usecase;

import org.mifos.mobilewallet.auth.domain.model.Bank;
import org.mifos.mobilewallet.auth.domain.usecase.FetchBanks;
import org.mifos.mobilewallet.core.UseCase;
import org.mifos.mobilewallet.data.local.LocalRepository;
import org.mifos.mobilewallet.invoice.domain.model.PaymentMethod;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by naman on 20/6/17.
 */

public class FetchPaymentMethods extends UseCase<FetchPaymentMethods.RequestValues,
        FetchPaymentMethods.ResponseValue> {

    private final LocalRepository localRepository;

    @Inject
    public FetchPaymentMethods(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }


    @Override
    protected void executeUseCase(FetchPaymentMethods.RequestValues requestValues) {
        getUseCaseCallback().onSuccess(new
                FetchPaymentMethods.ResponseValue(localRepository.getPaymentMethods()));
    }

    public static final class RequestValues implements UseCase.RequestValues {

        public RequestValues() {
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {

        private List<PaymentMethod> paymentMethods;

        public ResponseValue(List<PaymentMethod> methods) {
            this.paymentMethods = methods;
        }

        public List<PaymentMethod> getPaymentMethods() {
            return paymentMethods;
        }
    }

}


