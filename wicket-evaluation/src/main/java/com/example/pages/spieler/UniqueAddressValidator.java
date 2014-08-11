package com.example.pages.spieler;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import com.example.model.Player;
import com.example.services.PlayerService;

public class UniqueAddressValidator implements IValidator<String> {

	@Inject
	PlayerService playerService;
	
	Long _alloweCollisionId;
	
	public UniqueAddressValidator(Player player) {
		Injector.get().inject(this);
		_alloweCollisionId = player.getId();
	}

	@Override
	public void validate(IValidatable<String> validateEmail) {
		Player p =  playerService.findByEmail(validateEmail.getValue());
		if(p!=null && !p.getId().equals(_alloweCollisionId)) {
			validateEmail.error(new ValidationError("Die E-Mail ist schon vergeben"));
		}
	}

}
