/**
 * 
 */
package com.isesalud.controller.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.isesalud.controller.security.SecurityComponent;
import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.persistence.CancerOtrasPartesPersistenceEjb;
import com.isesalud.ejb.persistence.ParienteCancerMamaPersistenceEjb;
import com.isesalud.ejb.persistence.PatientPersistenceEjb;
import com.isesalud.ejb.persistence.PreviaEnfermedadPersistenceEjb;
import com.isesalud.ejb.persistence.SintomaCancerMamaPersistenceEjb;
import com.isesalud.model.CancerOtrasPartes;
import com.isesalud.model.Paciente;
import com.isesalud.model.ParienteCancerMama;
import com.isesalud.model.PreviaEnfermedad;
import com.isesalud.model.SintomaCancerMama;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ConversationScoped
public class PatientPersistence extends BaseManagedCrudController<Paciente, PatientPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8376685298021320691L;
	
	@EJB
	private PatientPersistenceEjb manager;
	
	@EJB
	private PreviaEnfermedadPersistenceEjb previaEnfermedadPersistenceEjb;
	@EJB
	private CancerOtrasPartesPersistenceEjb cancerOtrasPartesPersistenceEjb;
	@EJB
	private ParienteCancerMamaPersistenceEjb parienteCancerMamaPersistenceEjb;
	@EJB
	private SintomaCancerMamaPersistenceEjb sintomaCancerMamaPersistenceEjb;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private SecurityComponent securityComponent;
	
	@Inject
	private PatientSelection patientSelection;
	
	@Inject @Any
	private Event<Paciente> patientEditedEvent;
	
	/**************CHILD LIST*******************************************/
	private PreviaEnfermedad previaEnfermedad = new PreviaEnfermedad();
	private CancerOtrasPartes cancerOtrasPartes = new CancerOtrasPartes();
	private ParienteCancerMama parienteCancerMama = new ParienteCancerMama();
	private SintomaCancerMama sintomaCancerMama = new SintomaCancerMama();
	
	private List<PreviaEnfermedad> prevEnfList = new ArrayList<PreviaEnfermedad>();
	private List<CancerOtrasPartes> cancerList = new ArrayList<CancerOtrasPartes>();
	private List<ParienteCancerMama> parienteList = new ArrayList<ParienteCancerMama>();
	private List<SintomaCancerMama> sintomaList = new ArrayList<SintomaCancerMama>();
	
	public PreviaEnfermedad getPreviaEnfermedad() {
		return previaEnfermedad;
	}
	
	public void setPreviaEnfermedad(PreviaEnfermedad previaEnfermedad) {
		this.previaEnfermedad = previaEnfermedad;
	}
	
	public CancerOtrasPartes getCancerOtrasPartes() {
		return cancerOtrasPartes;
	}
	
	public void setCancerOtrasPartes(CancerOtrasPartes cancerOtrasPartes) {
		this.cancerOtrasPartes = cancerOtrasPartes;
	}
	
	public ParienteCancerMama getParienteCancerMama() {
		return parienteCancerMama;
	}
	
	public void setParienteCancerMama(ParienteCancerMama parienteCancerMama) {
		this.parienteCancerMama = parienteCancerMama;
	}
	
	public List<PreviaEnfermedad> getPrevEnfList() {
		return prevEnfList;
	}
	
	public SintomaCancerMama getSintomaCancerMama() {
		return sintomaCancerMama;
	}
	
	public void setSintomaCancerMama(SintomaCancerMama sintomaCancerMama) {
		this.sintomaCancerMama = sintomaCancerMama;
	}
	
	public void setPrevEnfList(List<PreviaEnfermedad> prevEnfList) {
		this.prevEnfList = prevEnfList;
	}
	
	public List<CancerOtrasPartes> getCancerList() {
		return cancerList;
	}
	
	public void setCancerList(List<CancerOtrasPartes> cancerList) {
		this.cancerList = cancerList;
	}
	
	public List<ParienteCancerMama> getParienteList() {
		return parienteList;
	}
	
	public void setParienteList(List<ParienteCancerMama> parienteList) {
		this.parienteList = parienteList;
	}
	
	public List<SintomaCancerMama> getSintomaList() {
		return sintomaList;
	}
	
	public void setSintomaList(List<SintomaCancerMama> sintomaList) {
		this.sintomaList = sintomaList;
	}
	/*************END CHILD LIST*****************************************/
	
	
	@PostConstruct
	public void initialize(){		
		setModel(patientSelection.getPaciente());
	}
	
	@Override
	protected void doBeforeSave() throws BaseException {
		super.doBeforeSave();
		getModel().setParientescancermama(parienteList);
		getModel().setCanceresOtraPartes(cancerList);
		getModel().setPreviasenfermedades(prevEnfList);
		getModel().setSintomasCancerMama(sintomaList);
	}
	
	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient())
			conversation.begin();
		getModel().setMunicipio(securityComponent.getCurrentUser().getMunicipio());
		setOutcome("/pacientes/PacientesEntradas");
		super.doAfterAdd();
	}
	
	@Override
	protected void doBeforeEdit() throws BaseException {
		super.doBeforeEdit();
		if(conversation.isTransient())
			conversation.begin();
	}
	
	@Override
	protected void doAfterEdit() throws BaseException {
		super.doAfterEdit();
		
		this.cancerList = getModel().getCanceresOtraPartes();
		this.sintomaList = getModel().getSintomasCancerMama();
		this.parienteList = getModel().getParientescancermama();
		this.prevEnfList = getModel().getPreviasenfermedades();
	}
	
	@Override
	protected void doAfterSave() throws BaseException {
		super.doAfterSave();
		
		patientEditedEvent.fire(getModel());
		
		if(!conversation.isTransient())
			conversation.end();
	}
	
	@Override
	protected void doAfterCancel() throws BaseException {
		super.doAfterCancel();
		if(!conversation.isTransient())
			conversation.end();
	}
	
	@Override
	public void edit(ActionEvent actionEvent) {
		if(patientSelection.getPaciente() == null){
			JSFUtil.warn("Seleccione a un paciente primero");
			setOutcome(null);
			return;
		} else {
			setModel(patientSelection.getPaciente());
		}
		
		setOutcome("/pacientes/PacientesEntradas");
		super.edit(actionEvent);
	}
	
	public void addCancerOtrasPartes(ActionEvent e){
		if(this.cancerOtrasPartes.getParteCuerpo() != null && !this.cancerOtrasPartes.getParteCuerpo().isEmpty()){
			this.cancerOtrasPartes.setPaciente(getModel());
			this.cancerList.add(cancerOtrasPartes);
			this.cancerOtrasPartes = new CancerOtrasPartes();
		}
	}
	
	public void addPreviaEnfermedad(ActionEvent e){
		if(this.previaEnfermedad.getIllness() != null && !this.previaEnfermedad.getIllness().isEmpty()){
			this.previaEnfermedad.setPaciente(getModel());
			this.prevEnfList.add(previaEnfermedad);
			this.previaEnfermedad = new PreviaEnfermedad();
		}
	}
	
	public void addParienteCancerMama(ActionEvent e){
		if(this.parienteCancerMama.getRelative() != null && !this.parienteCancerMama.getRelative().isEmpty()){
			this.parienteCancerMama.setPaciente(getModel());
			this.parienteList.add(parienteCancerMama);
			this.parienteCancerMama = new ParienteCancerMama();
		}
	}
	
	public void addSintomaCancerMama(ActionEvent e){
		if(this.sintomaCancerMama.getSintomaNombre() != null && !this.sintomaCancerMama.getSintomaNombre().isEmpty()){
			this.sintomaCancerMama.setPaciente(getModel());
			this.sintomaList.add(sintomaCancerMama);
			this.sintomaCancerMama = new SintomaCancerMama();
		}
	}
	
	public void erasePreviasEnfermedades(ActionEvent e){
		PreviaEnfermedad p = (PreviaEnfermedad) e.getComponent().getAttributes().get("selectIllnes");
		eraseFromList(this.prevEnfList, this.previaEnfermedadPersistenceEjb, p);
	}
	
	public void eraseCancerOtrasPartes(ActionEvent e){
		CancerOtrasPartes p = (CancerOtrasPartes) e.getComponent().getAttributes().get("selectCancer");
		eraseFromList(this.cancerList, this.cancerOtrasPartesPersistenceEjb, p);
	}
	
	public void eraseParienteCancer(ActionEvent e){
		ParienteCancerMama p = (ParienteCancerMama) e.getComponent().getAttributes().get("selectPariente");
		eraseFromList(this.parienteList, this.parienteCancerMamaPersistenceEjb, p);
	}
	
	public void eraseSintomaCancer(ActionEvent e){
		SintomaCancerMama p = (SintomaCancerMama) e.getComponent().getAttributes().get("selectSintoma");
		eraseFromList(this.sintomaList, this.sintomaCancerMamaPersistenceEjb, p);
	}

	@Override
	protected PatientPersistenceEjb getCrudManager() {
		return this.manager;
	}

	@Override
	protected Paciente getNewModel() {
		return new Paciente();
	}

	@Override
	protected String getAddRole() {
		return null;
	}

	@Override
	protected String getEditRole() {
		return null;
	}

	@Override
	protected String getDeleteRole() {
		return null;
	}

	@Override
	protected String getViewRole() {
		return null;
	}

}
