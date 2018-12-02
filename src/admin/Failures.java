package admin;

public class Failures {

    private  Integer idFailures;
    private  String dateFailures;
    private  String timeFailures;
    private  String detailsFailures;
    private  String durationFailures;
    private  String causesFailures;
    private  String effectsFailures;
    private  String commentsFailures;
    private  String signatureFailures;



    public Failures(Integer idFailures, String dateFailures, String timeFailures, String detailsFailures, String durationFailures, String causesFailures, String effectsFailures, String commentsFailures, String signatureFailures) {
        super();
        this.idFailures = new Integer(idFailures);
        this.dateFailures = dateFailures;
        this.timeFailures = timeFailures;
        this.detailsFailures = detailsFailures;
        this.durationFailures = durationFailures;
        this.causesFailures = causesFailures;
        this.effectsFailures = effectsFailures;
        this.commentsFailures = commentsFailures;
        this.signatureFailures = signatureFailures;






    }

    public Integer getIdFailures() {
        return idFailures;
    }

    public void setIdFailures(Integer idFailures) {
        this.idFailures = idFailures;
    }

    public String getDateFailures() {
        return dateFailures;
    }

    public void setDateFailures(String dateFailures) {
        this.dateFailures = dateFailures;
    }

    public String getTimeFailures() {
        return timeFailures;
    }

    public void setTimeFailures(String timeFailures) {
        this.timeFailures = timeFailures;
    }

    public String getDetailsFailures() {
        return detailsFailures;
    }

    public void setDetailsFailures(String detailsFailures) {
        this.detailsFailures = detailsFailures;
    }

    public String getDurationFailures() {
        return durationFailures;
    }

    public void setDurationFailures(String durationFailures) {
        this.durationFailures = durationFailures;
    }

    public String getCausesFailures() {
        return causesFailures;
    }

    public void setCausesFailures(String causesFailures) {
        this.causesFailures = causesFailures;
    }

    public String getEffectsFailures() {
        return effectsFailures;
    }

    public void setEffectsFailures(String effectsFailures) {
        this.effectsFailures = effectsFailures;
    }

    public String getCommentsFailures() {
        return commentsFailures;
    }

    public void setCommentsFailures(String commentsFailures) {
        this.commentsFailures = commentsFailures;
    }

    public String getSignatureFailures() {
        return signatureFailures;
    }

    public void setSignatureFailures(String signatureFailures) {
        this.signatureFailures = signatureFailures;
    }

    //
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getName2() {
//        return name2;
//    }
//
//    public String getName3() {
//        return name3;
//    }
//
//    public void setId(Integer id) {
//        this.id=id;
//    }
//
//    public void setName(String name) {
//        this.name=name;
//    }
//
//    public void setName2(String name2) {
//        this.name2=name2;
//    }
//
//    public void setName3(String name3) {
//       this.name3=name3;
//    }


}
