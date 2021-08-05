package com.intership.shortenerurl.service;

import com.intership.shortenerurl.Exception.BadRequestException;
import com.intership.shortenerurl.Exception.NotFoundException;
import com.intership.shortenerurl.entity.Redirect;
import com.intership.shortenerurl.repository.RedirectRepository;
import com.intership.shortenerurl.request.RedirectCreationRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class RedirectService {
    @Autowired
    private RedirectRepository redirectRepository;

    public Optional<Redirect> createRedirect(RedirectCreationRequest redirectCreationRequest) {
        if (redirectRepository.existsByAlias(redirectCreationRequest.getAlias())) {
            throw new BadRequestException("The domain name is already taken.");
        }

        Redirect redirect = new Redirect(redirectCreationRequest.getAlias(), redirectCreationRequest.getUrl());

        Redirect postSaveRedirect = redirectRepository.save(redirect);

        return Optional.ofNullable(postSaveRedirect);
    }

    public Redirect getRedirect(String alias) {
        Redirect redirect = redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Address not available."));
        return redirect;
    }

}
