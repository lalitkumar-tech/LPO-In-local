package com.lalit.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.lalit.config.EnvVariables;
import com.lalit.constants.AppConstants;
import com.lalit.constants.MessageConstant;
import com.lalit.domain.Address;
import com.lalit.domain.Contact;
import com.lalit.domain.Country;
import com.lalit.domain.State;
import com.lalit.domain.User;
import com.lalit.dto.ChildDto;
import com.lalit.dto.SpouseDto;
import com.lalit.enums.BeneficiaryType;
import com.lalit.enums.Gender;
import com.lalit.enums.RelationType;
import com.lalit.enums.StaysWith;
import com.lalit.exception.DataAlreadyExistException;
import com.lalit.exception.DataNotFoundException;
import com.lalit.repository.ContactRepository;
import com.lalit.repository.CountryRepository;
import com.lalit.repository.StateRepository;
import com.lalit.repository.UserRepository;
import com.lalit.util.service.UtilService;
import com.lalit.utils.GeneralUtils;
import com.lalit.utils.LocaleService;





@Component
public class ContactMapper {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	LocaleService localeService;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	private EnvVariables envVariables;

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactMapper.class);

	public static SpouseDto toSpouseDto(Contact contact) {
		SpouseDto spouseDto = new SpouseDto();
		spouseDto.setId(contact.getId());
		spouseDto.setSpouseId(contact.getUser().getId());
		spouseDto.setAccountType(contact.getAccountType());

		spouseDto.setFullName(contact.getFullName());
		spouseDto.setFirstName(contact.getFirstName());
		spouseDto.setMiddleName(contact.getMiddleName());
		spouseDto.setLastName(contact.getLastName());
		spouseDto.setPreferredName(contact.getPreferredName());

		spouseDto.setEmail(contact.getEmail());
		spouseDto.setSecondaryEmail(contact.getSecondaryEmail());
		spouseDto.setTertiaryEmail(contact.getTertiaryEmail());

		spouseDto.setPhoneNumber(contact.getPhoneNumber());
		spouseDto.setSecondaryMobileNumber(contact.getSecondaryMobileNumber());
		spouseDto.setTertiaryMobileNumber(contact.getTertiaryMobileNumber());
		spouseDto.setLandLineContactNumber(contact.getLandLineContactNumber());

		boolean isChild = false;
		copyOtherValuesTodto(spouseDto, contact);
		copyAddressDetails(contact, spouseDto);
		return spouseDto;
	}

	/*
	 * private static void copyAddressDetails(SpouseDto spouseDto, Contact
	 * spouse) { if (spouse.getCountry() != null) {
	 * spouseDto.setCountryId(spouse.getCountry().getCountryId());
	 * spouseDto.setCountry(spouse.getCountry().getName()); } if
	 * (spouse.getState() != null) {
	 * spouseDto.setStateId(spouse.getState().getId());
	 * spouseDto.setState(spouse.getState().getStateName()); }
	 * spouseDto.setCity(spouse.getCity2());
	 * spouseDto.setAddressLine1(spouse.getAddressLine1());
	 * spouseDto.setAddressLine2(spouse.getAddressLine2());
	 * spouseDto.setZipCode(spouse.getZipCode()); }
	 */
	private static void copyOtherValuesTodto(SpouseDto spouseDto, Contact contact) {
		spouseDto.setLivingWithSpouse(contact.getLivingWithSpouse());
		spouseDto.setEmergencyContactNumber(contact.getEmergencyContactNumber());
		spouseDto.setDob(Objects.isNull(contact.getDob()) ? null : GeneralUtils.getDateInFormat(contact.getDob()));
		spouseDto.setSpouseGender(contact.getGender().getValue());
		spouseDto.setRelation(contact.getRelation().getValue());
		LOGGER.info("================check relation value===========" + contact.getRelation().getValue());
		spouseDto.setUsCitizen(contact.getIsUsCitizen());
		spouseDto.setCitizenShip(contact.getCitizenShip());
		spouseDto.setIsFiduciary(contact.getIsFiduciary());
		spouseDto.setIsBeneficiary(contact.getIsBeneficiary());
		spouseDto.setIsEmergencyContact(contact.getIsEmergencyContact());
		spouseDto.setUserBeneficiary(contact.getUserBeneficiary());
		spouseDto.setUserFiduciary(contact.getUserFiduciary());
		spouseDto.setUserEmergencyContact(contact.getUserEmergencyContact());
	}

	public static ChildDto toChildDto(Contact contact) {
		ChildDto childDto = new ChildDto();
		childDto.setId(contact.getId());
		childDto.setParentId(contact.getUser().getId());
		childDto.setFullName(contact.getFullName());

		childDto.setFirstName(contact.getFirstName());
		childDto.setMiddleName(contact.getMiddleName());
		childDto.setLastName(contact.getLastName());

		childDto.setNickName(contact.getNickName());
		childDto.setEmail(contact.getEmail());
		childDto.setSecondaryEmail(contact.getSecondaryEmail());
		childDto.setTertiaryEmail(contact.getTertiaryEmail());

		childDto.setPhoneNumber(contact.getPhoneNumber());
		childDto.setLandlineContactNumber(contact.getLandLineContactNumber());
		childDto.setSecondaryMobileNumber(contact.getSecondaryMobileNumber());
		childDto.setTertiaryMobileNumber(contact.getTertiaryMobileNumber());
		childDto.setEmergencyContactNumber(contact.getEmergencyContactNumber());
		childDto.setDob(Objects.isNull(contact.getDob()) ? null : GeneralUtils.getDateInFormat(contact.getDob()));
		childDto.setCitizenShip(contact.getCitizenShip());
		childDto.setIsUsCitizen(contact.getIsUsCitizen());

		if (contact.getGender() != null) {
			childDto.setChildGender(contact.getGender().getValue());

		}

		LocalDate birthday = contact.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LOGGER.info("=================child birthday = " + birthday + "========");
		Period period = Period.between(birthday, LocalDate.now());
		LOGGER.info("=================period(age of child in year) =" + period + "===========");
		LOGGER.info("=================period(age of child in year) =" + period.getYears() + "===========");
		if (period.getYears() > 18) {
			childDto.setMinor(false);
		} else {
			childDto.setMinor(true);
			childDto.setGuardianName(contact.getGuardianName());
			childDto.setGuardianEmail(contact.getGuardianEmail());
			childDto.setGuardianPhoneNumber(contact.getGuardianPhoneNumber());
		}
		childDto.setStaysWith(contact.getStaysWith() == null ? null : contact.getStaysWith().getValue());

		childDto.setIsFiduciary(contact.getIsFiduciary());
		childDto.setIsBeneficiary(contact.getIsBeneficiary());
		childDto.setIsHerChild(contact.getIsHerChild());
		childDto.setIsHisChild(contact.getIsHisChild());
		childDto.setIsOurChild(contact.getIsOurChild());
		childDto.setIsDeceased(contact.getIsDeceased());
		childDto.setHasSpecialNeeds(contact.getHasSpecialNeeds());
		childDto.setRequiresAssistance(contact.getRequiresAssistance());
		childDto.setOccupation(contact.getOccupation());
		childDto.setIsEmergencyContact(contact.getIsEmergencyContact());

		childDto.setRelation(contact.getRelation().getValue());
		LOGGER.info("==========relation value dto============" + contact.getRelation().getValue());
		childDto.setRelationText(contact.getRelation().getText());
		LOGGER.info("==========relation text dto============" + contact.getRelation().getText());

		copyAddressDetails(contact, childDto);
		return childDto;
	}

	private static void copyAddressDetails(Contact contact, SpouseDto spouseDto) {
		if (contact.getCountry() != null) {
			spouseDto.setCountryId(contact.getCountry().getCountryId());
			spouseDto.setCountry(contact.getCountry().getName());
		}
		if (contact.getState() != null) {
			spouseDto.setStateId(contact.getState().getId());
			spouseDto.setState(contact.getState().getStateName());
		}

		spouseDto.setCity(contact.getCity2());
		spouseDto.setAddressLine1(contact.getAddressLine1());
		spouseDto.setAddressLine2(contact.getAddressLine2());
		spouseDto.setZipCode(contact.getZipCode());
	}

	private static void copyAddressDetails(Contact contact, ChildDto childDto) {
		if (contact.getCountry() != null) {
			childDto.setCountryId(contact.getCountry().getCountryId());
			childDto.setCountry(contact.getCountry().getName());
		}
		if (contact.getState() != null) {
			childDto.setStateId(contact.getState().getId());
			childDto.setState(contact.getState().getStateName());

		}
		childDto.setCity(contact.getCity2());
		childDto.setAddressLine1(contact.getAddressLine1());
		childDto.setAddressLine2(contact.getAddressLine2());
		childDto.setZipCode(contact.getZipCode());
	}

	public Contact toSpouse(SpouseDto spouseDto) {
		Contact spouse = null;
		boolean newSpouse = true;
		if (spouseDto.getId() != null) {
			LOGGER.info("================updating the existing user==================");
			// fetching the spouse by userId, spouseId and relation
			// throw error if spouse is not found
			// set newSpouse to false
			spouse = contactRepository.findByIdAndUserIdAndRelationInAndDeletedFalse(spouseDto.getId(),
					spouseDto.getSpouseId(), Arrays.asList(RelationType.WIFE, RelationType.HUSBAND));
			if (Objects.isNull(spouse)) {
				LOGGER.info("========= Exception===> spouse Not Found (invalid spouse id)=====");
				throw DataNotFoundException.of(localeService.getMessage(MessageConstant.SPOUSE_NOT_FOUND));
			}
			newSpouse = false;

		} else {
			LOGGER.info("=============adding new User===================");
			// checking whether the spouse is more than 0, if yes throw error
			// SPOUSE ALREADY PRESENT
			// calling CheckDuplicateEntry by passing spouseFields such as
			// spouseId,spouseEmail,isBeneficaiary,isFiduciary
			// create new Contact and assign to spouse
			if (contactRepository.countByUserIdAndRelationInAndDeletedFalse(spouseDto.getSpouseId(),
					Arrays.asList(RelationType.HUSBAND, RelationType.WIFE)) > 0) {
				throw DataNotFoundException.of(localeService.getMessage(MessageConstant.SPOUSE_ALREADY_PRESENT));
			}
			checkDuplicateEntry(spouseDto.getSpouseId(), spouseDto.getEmail(), spouseDto.getIsBeneficiary(),
					spouseDto.getIsFiduciary());
			
			spouse = new Contact();
		}

		Optional<User> optBetterHalf = userRepo.findByIdAndEnabledTrue(spouseDto.getSpouseId());
		if (optBetterHalf.isPresent()) {
			spouse.setUser(optBetterHalf.get());
			spouse.setAccountType(optBetterHalf.get().getAccountType() == null ? null
					: optBetterHalf.get().getAccountType().getValue());
		} else {
			throw DataNotFoundException.of(localeService.getMessage(MessageConstant.USER_NOT_FOUND));
		}
		
		
		if (spouseDto.getIsEmergencyContact() != null && spouseDto.getIsEmergencyContact()) {
			LOGGER.info("=====checking for Emergency contact ============");
			if (newSpouse || Objects.isNull(spouse.getIsEmergencyContact()) || !spouse.getIsEmergencyContact()) {
				long num = contactRepository
						.countByUserIdAndIsEmergencyContactTrueAndDeletedFalse(spouseDto.getSpouseId());
				if (num >= envVariables.getMaxEmergencyContact()) {
					throw DataNotFoundException.of(localeService.getMessage(MessageConstant.MAX_EMERGENCY_CONTACT_ALLOWED,
							new Object[] { envVariables.getMaxEmergencyContact() }));
				}

			}
		}
		spouse.setIsEmergencyContact(spouseDto.getIsEmergencyContact());
		spouse.setIsFiduciary(spouseDto.getIsFiduciary());
		spouse.setIsBeneficiary(spouseDto.getIsBeneficiary());
		
		if(Objects.isNull(spouseDto.getIsUsCitizen()))
			throw DataNotFoundException.of(localeService.getMessage(MessageConstant.US_CITIZEN_NOT_SELECTED));

		spouse.setIsUsCitizen(spouseDto.getIsUsCitizen());

		spouse.setCitizenShip(spouseDto.getCitizenShip());

		spouse.setLegalStatus(spouseDto.getLegalStatus());
		spouse.setFullName(spouseDto.getFullName());

		spouse.setFirstName(spouseDto.getFirstName());
		spouse.setMiddleName(spouseDto.getMiddleName());
		spouse.setLastName(spouseDto.getLastName());

		spouse.setPreferredName(spouseDto.getPreferredName());
		spouse.setNickName(spouseDto.getPreferredName());
		spouse.setEmail(spouseDto.getEmail());
		spouse.setSecondaryEmail(spouseDto.getSecondaryEmail());
		spouse.setTertiaryEmail(spouseDto.getTertiaryEmail());

		spouse.setPhoneNumber(spouseDto.getPhoneNumber());
		spouse.setSecondaryMobileNumber(spouseDto.getSecondaryMobileNumber());
		spouse.setTertiaryMobileNumber(spouseDto.getTertiaryMobileNumber());
		spouse.setLandLineContactNumber(spouseDto.getLandLineContactNumber());
		spouse.setLivingWithSpouse(spouseDto.getLivingWithSpouse());

		spouse.setEmergencyContactNumber(spouseDto.getEmergencyContactNumber());
		spouse.setDob(GeneralUtils.getDate(spouseDto.getDob()));
		spouse.setGender(Gender.getByName(spouseDto.getSpouseGender()));

		if (spouse.getGender().equals(Gender.MALE)) {
			spouse.setRelation(RelationType.HUSBAND);
		} else {
			spouse.setRelation(RelationType.WIFE);
		}

		spouse.setContactType(GeneralUtils.PERSONAL);
		spouse.setContactGroup(GeneralUtils.FAMILY_OR_CLOSE_FRIEND);
		spouse.setBeneficiaryType(BeneficiaryType.INDIVIDUAL);
		copyAddressDetails(spouseDto, spouse);
		
		return spouse;
	}
	

	private void copyAddressDetails(SpouseDto spouseDto, Contact spouse) {
		Optional<Country> optCountry = countryRepository.findById(spouseDto.getCountryId());
		if (optCountry.isPresent()) {
			Country country = optCountry.get();
			spouse.setCountry(country);
		}
		Optional<State> optState = stateRepository.findById(spouseDto.getStateId());
		if (optState.isPresent()) {
			State state = optState.get();
			spouse.setState(state);
		}
		spouse.setCity2(spouseDto.getCity());
		spouse.setAddressLine1(spouseDto.getAddressLine1());
		spouse.setAddressLine2(spouseDto.getAddressLine2());
		spouse.setZipCode(spouseDto.getZipCode());
	}

	private void checkDuplicateEntry(Long userId, String email, Boolean isBeneficiary, Boolean isFiduciary) {
		// fetching the contact fields
		// if present throw error EMAIL ALREADY EXISTED
		List<Contact> contactOpt = contactRepository.findByUserIdAndEmailAndIsFiduciaryAndIsBeneficiaryAndDeletedFalse(
				userId, email, isBeneficiary, isFiduciary);
		if (!contactOpt.isEmpty()) {
			throw DataAlreadyExistException.of(MessageConstant.EMAIL_ALREADY_EXISTED);
		}
	}

	public Contact tochild(ChildDto childDto) {
		LOGGER.info("=======converting the childDto to child object================");
		if (!RelationType.children.stream().anyMatch(child -> child.name().equals(childDto.getRelation()))) {
			LOGGER.info("=============relation checking =======================");
			throw DataNotFoundException.of(localeService.getMessage(MessageConstant.RELATION_SHOULD_EXISTS,
					new Object[] { RelationType.childrenList }));
		}
		Contact child = null;
		boolean newContact = true;
		if (childDto.getId() != null) {
			LOGGER.info("===========updating the existing child ===================");
			child = contactRepository.findByIdAndUserIdAndRelationInAndDeletedFalse(childDto.getId(),
					childDto.getParentId(), RelationType.children);
			if (Objects.isNull(child)) {
				throw DataNotFoundException.of(localeService.getMessage(MessageConstant.CHILD_NOT_FOUND));
			}
			newContact = false;
		} else {
			LOGGER.info("==============Adding new child=================");
			checkDuplicateEntryForChild(childDto.getParentId(), childDto.getFirstName(), childDto.getLastName(),
					RelationType.getByName(childDto.getRelation()));
			child = new Contact();
		}

		User parent = new User();
		parent.setId(childDto.getParentId());
		child.setUser(parent);

		child.setFullName(childDto.getFullName());
		child.setNickName(childDto.getNickName());
		child.setFirstName(childDto.getFirstName());
		child.setMiddleName(childDto.getMiddleName());
		child.setLastName(childDto.getLastName());
		child.setCitizenShip(childDto.getCitizenShip());

		child.setEmail(childDto.getEmail());
		child.setSecondaryEmail(childDto.getSecondaryEmail());
		child.setTertiaryEmail(childDto.getTertiaryEmail());

		child.setPhoneNumber(childDto.getPhoneNumber());
		child.setLandLineContactNumber(childDto.getLandlineContactNumber());
		child.setEmergencyContactNumber(childDto.getEmergencyContactNumber());
		child.setSecondaryMobileNumber(childDto.getSecondaryMobileNumber());
		child.setTertiaryMobileNumber(childDto.getTertiaryMobileNumber());
		child.setDob(GeneralUtils.getDate(childDto.getDob()));
		child.setGender(Gender.getByName(childDto.getChildGender()));
		child.setRelation(RelationType.getByName(childDto.getRelation()));
		LocalDate birthday = child.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period = Period.between(birthday, LocalDate.now());

		if (period.getYears() >= 13) {
			LOGGER.info("===========checking child age -->if 13 and more should have email=============");
			if (childDto.getEmail() == null || childDto.getEmail().trim().isEmpty()) {
				throw DataNotFoundException.of("Please provide a valid email address.");
			}
			if (UtilService.validate(childDto.getEmail())) {
				// LOGGER.info("Yes email is valid...");
				child.setEmail(childDto.getEmail().trim());
			}
		}

		boolean isMinor = period.getYears() < AppConstants.MINIMUM_AGE;
		child.setMinor(isMinor);
		if (isMinor) {
			LOGGER.info("==========if child is minor set its setIsEmergencyContact and setIsFiduciary to null ==============");
			childDto.setIsEmergencyContact(null);
			childDto.setIsFiduciary(null);
		}
		
		if (childDto.getIsEmergencyContact() != null && childDto.getIsEmergencyContact()) {
			LOGGER.info("==============isEmergencyContact flage is true==============");
			// either of new contact or existing contact don't have previously,
			// but wanted
			// it now.
			if (newContact || Objects.isNull(child.getIsEmergencyContact()) || !child.getIsEmergencyContact()) {
				long num = contactRepository
						.countByUserIdAndIsEmergencyContactTrueAndDeletedFalse(childDto.getParentId());
				if (num >= envVariables.getMaxEmergencyContact()) {
					LOGGER.info("=====you exceeds the limit of Max. emergency contacts=============");
					throw DataNotFoundException
							.of(localeService.getMessage(MessageConstant.MAX_EMERGENCY_CONTACT_ALLOWED,
									new Object[] { envVariables.getMaxEmergencyContact() }));
				}
			}
		}

		// Erasure fields
		child.setIsEmergencyContact(childDto.getIsEmergencyContact());

		if (Objects.isNull(childDto.getIsUsCitizen()))
			throw DataNotFoundException.of(localeService.getMessage(MessageConstant.US_CITIZEN_NOT_SELECTED));

		child.setIsUsCitizen(childDto.getIsUsCitizen());
		child.setIsDeceased(childDto.getIsDeceased());
		child.setHasSpecialNeeds(childDto.getHasSpecialNeeds());
		child.setRequiresAssistance(childDto.getRequiresAssistance());
		child.setIsFiduciary(childDto.getIsFiduciary());
		child.setIsBeneficiary(childDto.getIsBeneficiary());

		child.setIsHerChild(childDto.getIsHerChild());
		child.setIsHisChild(childDto.getIsHisChild());
		child.setIsOurChild(childDto.getIsOurChild());

		child.setOccupation(childDto.getOccupation());
		child.setStaysWith(StaysWith.getByName(childDto.getStaysWith()));

		child.setContactType(GeneralUtils.PERSONAL);
		child.setContactGroup(GeneralUtils.FAMILY_OR_CLOSE_FRIEND);
		child.setBeneficiaryType(BeneficiaryType.INDIVIDUAL);
		copyAddressDetails(childDto, child);
		return child;
	}

	private void checkDuplicateEntryForChild(Long userId, String firstName, String lastName, RelationType relation) {
		LOGGER.info("=============checking for duplicate entry===========");
		List<Contact> contactOptional = contactRepository
				.findByUserIdAndFirstNameAndLastNameAndRelationAndDeletedFalse(userId, firstName, lastName, relation);
		if (!contactOptional.isEmpty()) {
			throw new DataAlreadyExistException("Child is already exists");
		}
	}
	
	private void copyAddressDetails(ChildDto childDto, Contact child) {
		
		if (childDto.getStaysWith() != null) {
			Optional<User> optParent = userRepo.findByIdAndDeletedFalse(child.getUser().getId());
			User user = optParent.get();
			Address address = user.getAddress();
			if (!optParent.isPresent()) {
				throw new DataNotFoundException("Please specify the parent");
			}
			StaysWith staysWith = StaysWith.getByName(childDto.getStaysWith());

			switch (staysWith) {
			case CLIENT:
				child.setStaysWith(StaysWith.CLIENT);

				child.setCountry(address.getCountry());
				child.setState(address.getState());
				child.setCity2(childDto.getCity());
				child.setAddressLine1(address.getAddress_one());
				child.setAddressLine2(address.getAddress_two());
				child.setZipCode(address.getZipCode());
				break;
			case SPOUSE:
				child.setStaysWith(StaysWith.SPOUSE);
				
				List<Contact> spouse = contactRepository.findByUserIdAndRelationInAndDeletedFalse(user.getId(),
						Arrays.asList(RelationType.HUSBAND, RelationType.WIFE));
				if (spouse.isEmpty()) {
					throw new DataNotFoundException("Please specify the 2nd client");
				}
				Contact contact = spouse.get(0);
				
				child.setCountry(contact.getCountry());
				child.setState(contact.getState());
				child.setCity2(contact.getCity2());
				child.setAddressLine1(contact.getAddressLine1());
				child.setAddressLine2(contact.getAddressLine2());
				child.setZipCode(contact.getZipCode());

				break;
			case BOTH:
				child.setStaysWith(StaysWith.BOTH);
				
				child.setCountry(address.getCountry());
				child.setState(address.getState());
				child.setCity2(childDto.getCity());
				child.setAddressLine1(address.getAddress_one());
				child.setAddressLine2(address.getAddress_two());
				child.setZipCode(address.getZipCode());
				break;
			case NEITHER:
				child.setStaysWith(StaysWith.NEITHER);
				// LOGGER.info("Child does nocontactt stay with Neither : ");
				child.setGuardianName(childDto.getGuardianName());
				child.setGuardianPhoneNumber(childDto.getGuardianPhoneNumber());
				child.setGuardianEmail(childDto.getGuardianEmail());

				if (childDto.getCountryId() != null) {
					Optional<Country> optCountry = countryRepository.findById(childDto.getCountryId());
				
					if (optCountry.isPresent()) {
						Country country = optCountry.get();
						child.setCountry(country);
					}
					Optional<State> optState = stateRepository.findById(childDto.getStateId());
					if (optState.isPresent()) {
						State state = optState.get();
						child.setState(state);
					}
				}
				child.setCity2(childDto.getCity());
				child.setAddressLine1(childDto.getAddressLine1());
				child.setAddressLine2(childDto.getAddressLine2());
				child.setZipCode(childDto.getZipCode());
				break;
			default:
				break;
			}

		} else {
			LOGGER.error("parent id not found");
			throw DataNotFoundException.of("Please provide address particulars for child");
		}

	}

}







