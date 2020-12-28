package com.lalit.mapper;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lalit.constants.AppConstants;
import com.lalit.constants.MessageConstant;
import com.lalit.domain.Address;
import com.lalit.domain.Country;
import com.lalit.domain.EmployementDetail;
import com.lalit.domain.Role;
import com.lalit.domain.State;
import com.lalit.domain.User;
import com.lalit.dto.UserProfileDto;
import com.lalit.enums.AccountType;
import com.lalit.enums.AuthProvider;
import com.lalit.enums.DischageType;
import com.lalit.enums.Gender;
import com.lalit.enums.MaritalStatus;
import com.lalit.exception.DataNotFoundException;
import com.lalit.repository.CountryRepository;
import com.lalit.repository.RoleRepository;
import com.lalit.repository.StateRepository;
import com.lalit.repository.UserRepository;
import com.lalit.utils.LocaleService;




@Component
public class UserProfileMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileMapper.class);
			
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private LocaleService localeService;
	
	public User toUser(UserProfileDto userProfileDto,Long currentUserId) {
		User user = new User();
		if (userProfileDto.getUserId() != null) {
			LOGGER.info("==============existing user===================");
			Optional<User> findById = userRepository.findById(userProfileDto.getUserId());
			if (findById.isPresent()) {
				user = findById.get();
				//SKIDED THE FILE NAME CODE
			}
		}
		copyBasicDetails(userProfileDto, user);
		//Firm userFirm = copyFirm(principal);
		//user.setFirm(userFirm);

		Address address = copyAddressDetails(userProfileDto);
		user.setAddress(address);
		address.setUser(user);
		user.setVeteran(userProfileDto.isVeteran());
//		user.setd

		Role role = roleRepository.findByRoleAndDeletedFalse(AppConstants.CLIENT_ROLE);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);

//		LOGGER.info("user. isCurrentlyEmployed : {} ", user.isCurrentlyEmployed());

		if (userProfileDto.isCurrentlyEmployed() || userProfileDto.isVeteran()) {
			EmployementDetail employementDetail = copyEmploymentDetails(userProfileDto);
			user.setVeteran(userProfileDto.isVeteran());
			user.setEmploymentDetail(employementDetail);
		}
		return user;
	}

	private EmployementDetail copyEmploymentDetails(UserProfileDto clientProfileDto) {
		EmployementDetail employementDetail = new EmployementDetail();
		if (clientProfileDto.getEmploymentId() > 0) {
			employementDetail.setId(clientProfileDto.getEmploymentId());
		}
		employementDetail.setCompanyName(clientProfileDto.getCompanyName());
		employementDetail.setPhoneNumber(clientProfileDto.getCompanyPhoneNumber());
		employementDetail.setJobTitle(clientProfileDto.getJobTitle());
		if (clientProfileDto.isVeteran()) {
			DischageType byName = DischageType.getByName(clientProfileDto.getDischageType());
			employementDetail.setDischageType(byName);
			if(clientProfileDto.getJoiningDate().after(clientProfileDto.getDischargeDate())){
				throw new DataNotFoundException(localeService.getMessage(MessageConstant.JOINING_DATE_LESS_THAN_DISCHARGE_DATE));
			}
			employementDetail.setJoiningDate(clientProfileDto.getJoiningDate());
			employementDetail.setDischareDate(clientProfileDto.getDischargeDate());
		}
		return employementDetail;
	}
	
	private Address copyAddressDetails(UserProfileDto userProfileDto) {							//ask that why we are checking it with id
		Address address = new Address();
		if (userProfileDto.getAddressId() != null) {
			address.setId(userProfileDto.getAddressId());
		}
		// Make it optional
		if (userProfileDto.getCountryId() != null) {
			Optional<Country> optCountry = countryRepository.findById(userProfileDto.getCountryId());
			if (optCountry.isPresent()) {
				Country country = optCountry.get();
				address.setCountry(country);
			}
			Optional<State> optState = stateRepository.findById(userProfileDto.getStateId());
			if (optState.isPresent()) {
				State state = optState.get();
				address.setState(state);
			}
		}
		address.setCity(userProfileDto.getCity());
		address.setZipCode(userProfileDto.getZipCode());
		address.setAddress_one(userProfileDto.getAddressLine1());
		address.setAddress_two(userProfileDto.getAddressLine2());
		LOGGER.info("address is : {}", address.toString());
		return address;
	}

	private User copyBasicDetails(UserProfileDto dto, User user) {
		if (dto.getUserId() != null) {
			Optional<User> optUser = userRepository.findByIdAndEnabledTrue(dto.getUserId());
//			RelationType relation = Gender.MALE.getValue() == dto.getGender() ? RelationType.WIFE
//					: RelationType.HUSBAND;
//			Optional<Contact> spouse = contactRepository.findByUserIdAndRelation(dto.getUserId(), relation);
			if (optUser.get().getAccountType()==null) {
				user.setAccountType(null);	
			}else {
				user.setAccountType(AccountType.getByName(dto.getAccountType()));
			}
			user.setId(dto.getUserId());
		}
		user.setFirstName(dto.getFirstName());
		user.setMiddleName(dto.getMiddleName());
		user.setLastName(dto.getLastName());
		user.setPreferedName(dto.getPreferredName());

		// Don't set user name
//		user.setUserName(GenericUtils.getUserName(dto.getEmail()));
//		user.setEmail(dto.getEmail());

		user.setSecondaryEmail(dto.getSecondaryEmail());
		user.setTertiaryEmail(dto.getTertiaryEmail());

		user.setMobileNumber(dto.getMobileNumber());
		user.setSecondaryMobileNumber(dto.getSecondaryMobileNumber());
		user.setTertiaryMobileNumber(dto.getTertiaryMobileNumber());
		user.setLandlineContactNumber(dto.getLandlineContactNumber());

		if (dto.getGender() != null && !dto.getGender().isEmpty()) {
			user.setGender(Gender.valueOf(dto.getGender()));
		}
		user.setDob(dto.getDob());
		user.setMaritalStatus(MaritalStatus.getByName(dto.getMaritalStatus()));
		user.setRelationshipStatus(dto.isRelationshipStatus());
		user.setHasChildren(dto.isHasChildren());

		if(Objects.isNull(dto.getIsUsCitizen()))
			throw DataNotFoundException.of(localeService.getMessage(MessageConstant.US_CITIZEN_NOT_SELECTED));

		user.setUsCitizen(dto.getIsUsCitizen());
		user.setCitizenShip(dto.getCitizenShip());
		user.setAccountType(AccountType.getByName(dto.getAccountType()));

		user.setProvider(AuthProvider.lpo);
		user.setCurrentlyEmployed(dto.isCurrentlyEmployed());
		return user;
	}

	public UserProfileDto toUserProfileDto(User user) {
		UserProfileDto clientProfileDto = new UserProfileDto();
		clientProfileDto.setUserId(user.getId());
		clientProfileDto.setFirstName(user.getFirstName());
		clientProfileDto.setPreferredName(user.getPreferedName());
		clientProfileDto.setMiddleName(user.getMiddleName());
		clientProfileDto.setLastName(user.getLastName());
		clientProfileDto.setEmail(user.getEmail());
		clientProfileDto.setSecondaryEmail(user.getSecondaryEmail());
		clientProfileDto.setTertiaryEmail(user.getTertiaryEmail());
		clientProfileDto.setDob(user.getDob());
		clientProfileDto.setMobileNumber(user.getMobileNumber());
		clientProfileDto.setSecondaryMobileNumber(user.getSecondaryMobileNumber());
		clientProfileDto.setTertiaryMobileNumber(user.getTertiaryMobileNumber());
		clientProfileDto.setLandlineContactNumber(user.getLandlineContactNumber());
		clientProfileDto.setIsUsCitizen(user.isUsCitizen());
		clientProfileDto.setCitizenShip(user.getCitizenShip());
		clientProfileDto.setHasChildren(user.isHasChildren());
		clientProfileDto.setAccountType(user.getAccountType()==null? null:user.getAccountType().getValue());
		if (Objects.nonNull(user.getGender())) {
			clientProfileDto.setGender(user.getGender().getValue());
		}

		if (Objects.nonNull(user.getMaritalStatus())) {
			clientProfileDto.setMaritalStatus(user.getMaritalStatus().getValue());
		}

		clientProfileDto.setRelationshipStatus(user.isRelationshipStatus());

		Address address = user.getAddress();
		if (Objects.nonNull(address)) {
			clientProfileDto.setAddressId(address.getId());
			clientProfileDto.setAddressLine1(address.getAddress_one());
			clientProfileDto.setAddressLine2(address.getAddress_two());
			clientProfileDto.setZipCode(address.getZipCode());
			clientProfileDto.setCity(address.getCity());
			if (address.getCountry() != null) {
				clientProfileDto.setCountryId(address.getCountry().getCountryId());
				clientProfileDto.setCountry(address.getCountry().getName());
			}
			if (address.getState() != null) {
				clientProfileDto.setStateId(address.getState().getId());
				clientProfileDto.setState(address.getState().getStateName());
			}
		}

		LOGGER.info("user. isCurrentlyEmployed : {} ", user.isCurrentlyEmployed());

		clientProfileDto.setCurrentlyEmployed(user.isCurrentlyEmployed());
		clientProfileDto.setVeteran(user.isVeteran());
		if (user.isCurrentlyEmployed() || user.isVeteran()) {
			EmployementDetail employmentDetail = user.getEmploymentDetail();
			if (Objects.nonNull(employmentDetail)) {
				clientProfileDto.setEmploymentId(employmentDetail.getId());
				clientProfileDto.setCompanyName(employmentDetail.getCompanyName());
				clientProfileDto.setCompanyPhoneNumber(employmentDetail.getPhoneNumber());
				clientProfileDto.setJobTitle(employmentDetail.getJobTitle());
				if (employmentDetail.getDischageType() != null) {
					clientProfileDto.setDischageType(employmentDetail.getDischageType().getValue());
				}
			}
			clientProfileDto.setJoiningDate(employmentDetail.getJoiningDate());
			clientProfileDto.setDischargeDate(employmentDetail.getDischareDate());
		}

		return clientProfileDto;
	}

}
