package org.bigbluebutton.common2.msgs

import org.bigbluebutton.common2.domain.{PresentationPodVO, PresentationVO}


// ------------ client to akka-apps ------------
object CreateNewPresentationPodPubMsg { val NAME = "CreateNewPresentationPodPubMsg"}
case class CreateNewPresentationPodPubMsg(header: BbbClientMsgHeader, body: CreateNewPresentationPodPubMsgBody) extends StandardMsg
case class CreateNewPresentationPodPubMsgBody(ownerId: String)

object RemovePresentationPodPubMsg { val NAME = "RemovePresentationPodPubMsg"}
case class RemovePresentationPodPubMsg(header: BbbClientMsgHeader, body: RemovePresentationPodPubMsgBody) extends StandardMsg
case class RemovePresentationPodPubMsgBody(requesterId: String, podId: String)

object GetPresentationInfoReqMsg { val NAME = "GetPresentationInfoReqMsg"}
case class GetPresentationInfoReqMsg(header: BbbClientMsgHeader, body: GetPresentationInfoReqMsgBody) extends StandardMsg
case class GetPresentationInfoReqMsgBody(userId: String, podId: String)

object PresentationUploadTokenReqMsg { val NAME = "PresentationUploadTokenReqMsg"}
case class PresentationUploadTokenReqMsg(header: BbbClientMsgHeader, body: PresentationUploadTokenReqMsgBody) extends StandardMsg
case class PresentationUploadTokenReqMsgBody(podId: String, filename: String)

object GetAllPresentationPodsReqMsg { val NAME = "GetAllPresentationPodsReqMsg"}
case class GetAllPresentationPodsReqMsg(header: BbbClientMsgHeader, body: GetAllPresentationPodsReqMsgBody) extends StandardMsg
case class GetAllPresentationPodsReqMsgBody(requesterId: String)

object SetCurrentPagePubMsg { val NAME = "SetCurrentPagePubMsg"}
case class SetCurrentPagePubMsg(header: BbbClientMsgHeader, body: SetCurrentPagePubMsgBody) extends StandardMsg
case class SetCurrentPagePubMsgBody(podId: String, presentationId: String, pageId: String)

// ------------ client to akka-apps ------------


// ------------ bbb-common-web to akka-apps ------------
object PresentationConversionUpdateSysPubMsg { val NAME = "PresentationConversionUpdateSysPubMsg"}
case class PresentationConversionUpdateSysPubMsg(header: BbbClientMsgHeader,
                                                 body: PresentationConversionUpdateSysPubMsgBody) extends StandardMsg
case class PresentationConversionUpdateSysPubMsgBody(podId: String,
                                                     messageKey: String,
                                                     code: String,
                                                     presentationId: String,
                                                     presName: String)

object PresentationPageCountErrorSysPubMsg { val NAME = "PresentationPageCountErrorSysPubMsg"}
case class PresentationPageCountErrorSysPubMsg(header: BbbClientMsgHeader,
                                               body: PresentationPageCountErrorSysPubMsgBody) extends StandardMsg
case class PresentationPageCountErrorSysPubMsgBody(podId: String, messageKey: String, code: String, presentationId: String,
                                                   numberOfPages: Int, maxNumberPages: Int, presName: String)

object PresentationPageGeneratedSysPubMsg { val NAME = "PresentationPageGeneratedSysPubMsg"}
case class PresentationPageGeneratedSysPubMsg(header: BbbClientMsgHeader,
                                              body: PresentationPageGeneratedSysPubMsgBody) extends StandardMsg
case class PresentationPageGeneratedSysPubMsgBody(podId: String, messageKey: String, code: String, presentationId: String,
                                                  numberOfPages: Int, pagesCompleted: Int, presName: String)

object PresentationConversionCompletedSysPubMsg { val NAME = "PresentationConversionCompletedSysPubMsg"}
case class PresentationConversionCompletedSysPubMsg(header: BbbClientMsgHeader,
                                                    body: PresentationConversionCompletedSysPubMsgBody) extends StandardMsg
case class PresentationConversionCompletedSysPubMsgBody(podId: String, messageKey: String, code: String,
                                                        presentation: PresentationVO)
// ------------ bbb-common-web to akka-apps ------------


// ------------ akka-apps to client ------------
object CreateNewPresentationPodEvtMsg { val NAME = "CreateNewPresentationPodEvtMsg"}
case class CreateNewPresentationPodEvtMsg(header: BbbClientMsgHeader, body: CreateNewPresentationPodEvtMsgBody) extends StandardMsg
case class CreateNewPresentationPodEvtMsgBody(ownerId: String, podId: String)

object RemovePresentationPodEvtMsg { val NAME = "RemovePresentationPodEvtMsg"}
case class RemovePresentationPodEvtMsg(header: BbbClientMsgHeader, body: RemovePresentationPodEvtMsgBody) extends StandardMsg
case class RemovePresentationPodEvtMsgBody( ownerId: String, podId: String)

object GetPresentationInfoRespMsg { val NAME = "GetPresentationInfoRespMsg"}
case class GetPresentationInfoRespMsg(header: BbbClientMsgHeader, body: GetPresentationInfoRespMsgBody) extends BbbCoreMsg
case class GetPresentationInfoRespMsgBody(podId: String, presentations: Vector[PresentationVO])

object PresentationUploadTokenPassRespMsg { val NAME = "PresentationUploadTokenPassRespMsg"}
case class PresentationUploadTokenPassRespMsg(header: BbbClientMsgHeader, body: PresentationUploadTokenPassRespMsgBody) extends StandardMsg
case class PresentationUploadTokenPassRespMsgBody(podId: String, authzToken: String, filename: String)

object PresentationUploadTokenFailRespMsg { val NAME = "PresentationUploadTokenFailRespMsg"}
case class PresentationUploadTokenFailRespMsg(header: BbbClientMsgHeader, body: PresentationUploadTokenFailRespMsgBody) extends StandardMsg
case class PresentationUploadTokenFailRespMsgBody(podId: String, filename: String)

object PresentationConversionUpdateEvtMsg { val NAME = "PresentationConversionUpdateEvtMsg"}
case class PresentationConversionUpdateEvtMsg(header: BbbClientMsgHeader, body: PresentationConversionUpdateEvtMsgBody) extends BbbCoreMsg
case class PresentationConversionUpdateEvtMsgBody(podId: String, messageKey: String, code: String, presentationId: String, presName: String)

object PresentationPageCountErrorEvtMsg { val NAME = "PresentationPageCountErrorEvtMsg"}
case class PresentationPageCountErrorEvtMsg(header: BbbClientMsgHeader, body: PresentationPageCountErrorEvtMsgBody) extends BbbCoreMsg
case class PresentationPageCountErrorEvtMsgBody(podId: String, messageKey: String, code: String, presentationId: String, numberOfPages: Int, maxNumberPages: Int, presName: String)

object PresentationPageGeneratedEvtMsg { val NAME = "PresentationPageGeneratedEvtMsg"}
case class PresentationPageGeneratedEvtMsg(header: BbbClientMsgHeader, body: PresentationPageGeneratedEvtMsgBody) extends BbbCoreMsg
case class PresentationPageGeneratedEvtMsgBody(podId: String, messageKey: String, code: String, presentationId: String, numberOfPages: Int, pagesCompleted: Int, presName: String)

object PresentationConversionCompletedEvtMsg { val NAME = "PresentationConversionCompletedEvtMsg"}
case class PresentationConversionCompletedEvtMsg(header: BbbClientMsgHeader, body: PresentationConversionCompletedEvtMsgBody) extends BbbCoreMsg
case class PresentationConversionCompletedEvtMsgBody(podId: String, messageKey: String, code: String, presentation: PresentationVO)

object GetAllPresentationPodsRespMsg { val NAME = "GetAllPresentationPodsRespMsg"}
case class GetAllPresentationPodsRespMsg(header: BbbClientMsgHeader, body: GetAllPresentationPodsRespMsgBody) extends StandardMsg
case class GetAllPresentationPodsRespMsgBody(pods: Vector[PresentationPodVO])

object SetCurrentPageEvtMsg { val NAME = "SetCurrentPageEvtMsg"}
case class SetCurrentPageEvtMsg(header: BbbClientMsgHeader, body: SetCurrentPageEvtMsgBody) extends BbbCoreMsg
case class SetCurrentPageEvtMsgBody(podId: String, presentationId: String, pageId: String)

// ------------ akka-apps to client ------------


// ------------ akka-apps to bbb-common-web ------------
object PresentationUploadTokenSysPubMsg { val NAME = "PresentationUploadTokenSysPubMsg"}
case class PresentationUploadTokenSysPubMsg(header: BbbClientMsgHeader, body: PresentationUploadTokenSysPubMsgBody) extends BbbCoreMsg
case class PresentationUploadTokenSysPubMsgBody(podId: String, authzToken: String, filename: String)
// ------------ akka-apps to bbb-common-web ------------
