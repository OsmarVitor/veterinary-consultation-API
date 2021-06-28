package com.selecao.hapvida.provider;

import com.selecao.hapvida.domain.model.Tutor;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class TutorProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Tutor tutor = Tutor.newBuilder().name("Name Test").phoneNumber("123456789").email("email_teste@email.com").build();
        return Stream.of(tutor).map(Arguments::of);
    }
}
